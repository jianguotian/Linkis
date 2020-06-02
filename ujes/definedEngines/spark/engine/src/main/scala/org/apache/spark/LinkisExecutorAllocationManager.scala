package com.webank.wedatasphere.linkis.engine.executors;

import org.apache.spark.scheduler.LiveListenerBus
import org.apache.spark.{ExecutorAllocationClient, ExecutorAllocationManager, SparkConf}
import org.apache.spark.storage.BlockManagerMaster;

class LinkisExecutorAllocationManager extends ExecutorAllocationManager {

  override start() {

  }

}
