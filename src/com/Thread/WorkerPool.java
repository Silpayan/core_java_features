package com.Thread;

public class WorkerPool
{
  /**
   * The worker array.
   */
  private Worker[] workers;
  /**
   * A flag indicating whether idle workers are available.
   */
  private boolean workersAvailable;
  /**
   * the name prefix for all workers of this pool.
   */
  private String namePrefix;

  /**
   * Creates a new worker pool with the default size of 10 workers and the default name.
   */
  public WorkerPool ()
  {
    this(10);
  }

  /**
   * Creates a new workerpool with the given number of workers and the default name.
   *
   * @param size the maximum number of workers available.
   */
  public WorkerPool (final int size)
  {
    this(size, "WorkerPool-worker");
  }

  /**
   * Creates a new worker pool for the given number of workers and with the given name
   * prefix.
   *
   * @param size       the size of the worker pool.
   * @param namePrefix the name prefix for all created workers.
   */
  public WorkerPool (final int size, final String namePrefix)
  {
    if (size <= 0)
    {
      throw new IllegalArgumentException("Size must be > 0");
    }
    workers = new Worker[size];
    workersAvailable = true;
    this.namePrefix = namePrefix;
  }

  /**
   * Checks whether workers are available.
   *
   * @return true, if at least one worker is idle, false otherwise.
   */
  public synchronized boolean isWorkerAvailable ()
  {
    return workersAvailable;
  }

  /**
   * Updates the workersAvailable flag after a worker was assigned.
   */
  private void updateWorkersAvailable ()
  {
    for (int i = 0; i < workers.length; i++)
    {
      if (workers[i] == null)
      {
        workersAvailable = true;
        return;
      }
      if (workers[i].isAvailable() == true)
      {
        workersAvailable = true;
        return;
      }
    }
    workersAvailable = false;
  }

  /**
   * Waits until a worker will be available.
   */
  private synchronized void waitForWorkerAvailable ()
  {
    while (isWorkerAvailable() == false)
    {
      try
      {
        // remove lock
        this.wait(5000);
      }
      catch (InterruptedException ie)
      {
        // ignored
      }
    }
  }

  /**
   * Returns a workerhandle for the given workload. This method will wait until an idle
   * worker is found.
   *
   * @param r the workload for the worker
   * @return a handle to the worker.
   */
  public synchronized WorkerHandle getWorkerForWorkload (final Runnable r)
  {
    waitForWorkerAvailable();

    int emptySlot = -1;
    for (int i = 0; i < workers.length; i++)
    {
      if (workers[i] == null)
      {
        // in the first run, try to avoid to create new threads...
        // reuse the already available threads
        if (emptySlot == -1)
        {
          emptySlot = i;
        }
        continue;
      }
      if (workers[i].isAvailable() == true)
      {
        workers[i].setWorkload(r);
        updateWorkersAvailable();
        return new WorkerHandle(workers[i]);
      }
    }
    if (emptySlot != -1)
    {
      workers[emptySlot] = new Worker();
      workers[emptySlot].setName(namePrefix + '-' + emptySlot);
      workers[emptySlot].setWorkerPool(this);
      workers[emptySlot].setWorkload(r);
      updateWorkersAvailable();
      return new WorkerHandle(workers[emptySlot]);
    }
    throw new IllegalStateException
            ("At this point, a worker should already have been assigned.");
  }

  /**
   * Marks the given worker as finished. The worker will be removed from the list of the
   * available workers.
   *
   * @param worker the worker which was finished.
   */
  public void workerFinished (final Worker worker)
  {
    if (worker.isFinish() == false)
    {
      throw new IllegalArgumentException("This worker is not in the finish state.");
    }
    for (int i = 0; i < workers.length; i++)
    {
      if (workers[i] == worker)
      {
        synchronized (this)
        {
          workers[i] = null;
          workersAvailable = true;
          this.notifyAll();
        }
        return;
      }
    }
  }

  /**
   * Marks the given worker as available.
   *
   * @param worker the worker which was available.
   */
  public synchronized void workerAvailable (final Worker worker)
  {
    for (int i = 0; i < workers.length; i++)
    {
      if (workers[i] == worker)
      {
        synchronized (this)
        {
          workersAvailable = true;
          this.notifyAll();
        }
        return;
      }
    }
  }

  /**
   * Finishes all worker of this pool.
   */
  public void finishAll ()
  {
    for (int i = 0; i < workers.length; i++)
    {
      if (workers[i] != null)
      {
        workers[i].finish();
      }
    }
  }
}

/**
 * 
 * JFreeReport : a free Java reporting library
 * 
 *
 * Project Info:  http://reporting.pentaho.org/
 *
 * (C) Copyright 2001-2007, by Object Refinery Ltd, Pentaho Corporation and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ------------
 * Worker.java
 * ------------
 * (C) Copyright 2001-2007, by Object Refinery Ltd, Pentaho Corporation and Contributors.
 */


/**
 * A simple worker implementation. The worker executes a assigned workload and then sleeps
 * until another workload is set or the worker is killed.
 *
 * @author Thomas Morgner
 */
final class Worker extends Thread
{
  /**
   * the worker's task.
   */
  private Runnable workload;

  /**
   * a flag whether the worker should exit after the processing.
   */
  private volatile boolean finish;

  /**
   * the time in milliseconds beween 2 checks for exit or work requests.
   */
  private final int sleeptime;
  /**
   * The worker pool, to which this worker is assigned. May be null.
   */
  private WorkerPool workerPool;

  /**
   * Creates a new worker.
   *
   * @param sleeptime the time this worker sleeps until he checks for new work.
   */
  public Worker (final int sleeptime)
  {
    this.sleeptime = sleeptime;
    this.setDaemon(true);
    start();
  }

  /**
   * Creates a new worker with an default idle timeout of 2 minutes.
   */
  public Worker ()
  {
    this(120000);
  }

  /**
   * Set the next workload for this worker.
   *
   * @param r the next workload for the worker.
   * @throws IllegalStateException if the worker is not idle.
   */
  public void setWorkload (final Runnable r)
  {
    if (workload != null)
    {
      throw new IllegalStateException("This worker is not idle.");
    }
    //Log.debug("Workload set...");
    synchronized (this)
    {
      workload = r;
      //Log.debug("Workload assigned: Notified " + getName());
      this.notifyAll();
    }
  }

  /**
   * Returns the workload object.
   *
   * @return the runnable executed by this worker thread.
   */
  public synchronized Runnable getWorkload()
  {
    return workload;
  }

  /**
   * Kills the worker after he completed his work. Awakens the worker if he's sleeping, so
   * that the worker dies without delay.
   */
  public void finish ()
  {
    finish = true;
    // we are evil ..
    try
    {
      this.interrupt();
    }
    catch (SecurityException se)
    {
      // ignored
    }
    if (workerPool != null)
    {
      workerPool.workerFinished(this);
    }
  }

  /**
   * Checks whether this worker has some work to do.
   *
   * @return true, if this worker has no more work and is currently sleeping.
   */
  public boolean isAvailable ()
  {
    return (workload == null);
  }

  /**
   * If a workload is set, process it. After the workload is processed, this worker starts
   * to sleep until a new workload is set for the worker or the worker got the finish()
   * request.
   */
  public void run ()
  {
    while (!finish)
    {
      if (workload != null)
      {
        try
        {
          workload.run();
        }
        catch (Exception e)
        {
          System.out.println("Worker caught exception on run: "+ e);
        }
        workload = null;
        if (workerPool != null)
        {
          workerPool.workerAvailable(this);
        }
      }

      if (!finish)
      {
        synchronized (this)
        {
          try
          {
            // remove lock
            this.wait(sleeptime);
          }
          catch (InterruptedException ie)
          {
            // ignored
          }
        }
      }
    }

    synchronized (this)
    {
      this.notifyAll();
    }
  }

  /**
   * Checks whether this worker has received the signal to finish and die.
   *
   * @return true, if the worker should finish the work and end the thread.
   */
  public boolean isFinish ()
  {
    return finish;
  }

  /**
   * Returns the worker's assigned pool.
   *
   * @return the worker pool (or null, if the worker is not assigned to a pool).
   */
  public WorkerPool getWorkerPool ()
  {
    return workerPool;
  }

  /**
   * Defines the worker's assigned pool.
   *
   * @param workerPool the worker pool (or null, if the worker is not assigned to a
   *                   pool).
   */
  public void setWorkerPool (final WorkerPool workerPool)
  {
    this.workerPool = workerPool;
  }
}


/**
 * 
 * JFreeReport : a free Java reporting library
 * 
 *
 * Project Info:  http://reporting.pentaho.org/
 *
 * (C) Copyright 2001-2007, by Object Refinery Ltd, Pentaho Corporation and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ------------
 * WorkerHandle.java
 * ------------
 * (C) Copyright 2001-2007, by Object Refinery Ltd, Pentaho Corporation and Contributors.
 */


/**
 * The worker handle is a control structure which allows control over the worker without
 * exposing the thread object.
 *
 * @author Thomas Morgner
 * @deprecated This class is used by the WorkerPool, which is not used anywhere anymore.
 */
 class WorkerHandle
{
  /**
   * The worker for this handle.
   */
  private final Worker worker;

  /**
   * Creates a new handle for the given worker.
   *
   * @param worker the worker.
   */
  public WorkerHandle (final Worker worker)
  {
    this.worker = worker;
  }

  /**
   * Finishes the worker.
   */
  public void finish ()
  {
    worker.finish();
  }
}