package org.apache.spark

import com.webank.wedatasphere.linkis.resourcemanager.client.ResourceManagerClient
import org.apache.spark.scheduler.LiveListenerBus
import org.apache.spark.storage.BlockManagerMaster
import org.apache.spark.util.Clock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LinkisExecutorAllocationManager(client: ExecutorAllocationClient, listenerBus: LiveListenerBus, conf: SparkConf, blockManagerMaster: BlockManagerMaster)
  extends ExecutorAllocationManager (client, listenerBus, conf, blockManagerMaster) {
  @Autowired
  private var rmClient: ResourceManagerClient = _

  var clazz = Class.forName("org.apache.spark.ExecutorAllocationManager")

  override start() {
    rmClient.requestExpectedResource()
    super.start()
  }
}
