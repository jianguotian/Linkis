/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.resourcemanager.service.metadata

import java.util

import com.webank.wedatasphere.linkis.common.utils.{Logging, Utils}
import com.webank.wedatasphere.linkis.protocol.CacheableProtocol
import com.webank.wedatasphere.linkis.protocol.config.{RequestQueryAppConfig, RequestQueryAppConfigWithGlobal, ResponseQueryConfig}
import com.webank.wedatasphere.linkis.resourcemanager.utils.RMConfiguration
import com.webank.wedatasphere.linkis.rpc.RPCMapCache

/**
  * Created by shanhuang on 9/11/18.
  */
object UserConfiguration extends
  RPCMapCache[RequestQueryAppConfigWithGlobal, String, String](RMConfiguration.CLOUD_CONSOLE_CONFIGURATION_SPRING_APPLICATION_NAME.getValue) with Logging {

  override protected def createRequest(req: RequestQueryAppConfigWithGlobal): CacheableProtocol = req

  override protected def createMap(any: Any): util.Map[String, String] = any match {
    case response: ResponseQueryConfig => response.getKeyAndValue
  }

  override def getCacheMap(key: RequestQueryAppConfigWithGlobal): util.Map[String, String] = Utils.tryCatch(super.getCacheMap(key)) { case error: Throwable => warn(s"Failed to get Configuration:$key ", error)
    null
  }
}
