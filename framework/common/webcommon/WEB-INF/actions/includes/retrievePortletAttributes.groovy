/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.ofbiz.entity.*;
import org.ofbiz.entity.condition.*;

portalPageId = request.getAttribute("portalPageId");
portalPortletId = request.getAttribute("portalPortletId");
portletSeqId = request.getAttribute("portletSeqId");

portletAttributes = delegator.findList("PortletAttribute",
                                        EntityCondition.makeCondition([portalPageId : "_NA_", portalPortletId: portalPortletId, portletSeqId: "00000"]),
                                        null, null, null, false);
iter = portletAttributes.iterator();

while (iter) {
  attribute = iter.next();
  context.put(attribute.attrName, attribute.attrValue);
}

portletAttributes = delegator.findList("PortletAttribute",
                                        EntityCondition.makeCondition([portalPageId : portalPageId, portalPortletId: portalPortletId, portletSeqId: portletSeqId]),
                                        null, null, null, false);

iter = portletAttributes.iterator();

while (iter) {
  attribute = iter.next();
  context.put(attribute.attrName, attribute.attrValue);
}
