package org.apache.spark.util

import com.webank.wedatasphere.linkis.common.utils.ByteTimeUtils
import com.webank.wedatasphere.linkis.resourcemanager.YarnResource
import com.webank.wedatasphere.linkis.resourcemanager.client.ResourceManagerClient
import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.scheduler.{SparkListener, SparkListenerExecutorAdded, SparkListenerExecutorRemoved}
import org.springframework.beans.factory.annotation.Autowired

class ReourceStatusUpdateListener(sc: SparkContext) extends SparkListener with Logging {
  @Autowired
  private var rmClient: ResourceManagerClient = _

  override def onExecutorAdded(executorAdded: SparkListenerExecutorAdded): Unit = {
    //    val executorNum = executorAdded.executorInfo.totalCores
    val executorNum = sc.getExecutorMemoryStatus.map(_._1).size

    val executorMem: Long = ByteTimeUtils.byteStringAsBytes(sc.getConf.get("spark.executor.memory")) * executorNum
    val sparkExecutorCores = sc.getConf.get("spark.executor.cores").toInt * executorNum
    val queue = sc.getConf.get("spark.yarn.queue")

    val resource = new YarnResource(executorMem, sparkExecutorCores, 0, queue, sc.applicationId)

    rmClient.resourceStatusUpdated(resource)
  }

  override def onExecutorRemoved(executorRemoved: SparkListenerExecutorRemoved): Unit = {
    val executorNum = executorRemoved.
  }
}
