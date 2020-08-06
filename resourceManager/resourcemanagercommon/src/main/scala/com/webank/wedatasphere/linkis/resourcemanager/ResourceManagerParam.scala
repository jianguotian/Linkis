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

package com.webank.wedatasphere.linkis.resourcemanager

import com.webank.wedatasphere.linkis.resourcemanager.domain.{ModuleInfo, ModuleResourceInfo}
import com.webank.wedatasphere.linkis.resourcemanager.{Resource, ResultResource}
import com.webank.wedatasphere.linkis.common.ServiceInstance


/**
  * Created by shanhuang on 9/11/18.
  */
case class RequestResource(moduleInstance: ServiceInstance, user: String, creator: String, resource: Resource)

case class RequestExpectedResource(moduleInstance: ServiceInstance, user: String, ticketId: String, resource: Resource)

case class RequestResourceAndWait(moduleInstance: ServiceInstance, user: String, creator: String, resource: Resource, waitTime: Long)

case class ResourceInited(resource: ResultResource, moduleInstance: ServiceInstance, realUsed: Resource, engineInstance: ServiceInstance = null)

case class ResourceReleased(resultResource: ResultResource, moduleInstance: ServiceInstance)

case class ResourceOverload(moduleInstance: ServiceInstance)

case class ResourceInfo(resourceInfo: Array[ModuleResourceInfo])

case class ResourceUpdated(resource: ResultResource, moduleInstance: ServiceInstance, realUsed: Resource, engineInstance: ServiceInstance = null)


