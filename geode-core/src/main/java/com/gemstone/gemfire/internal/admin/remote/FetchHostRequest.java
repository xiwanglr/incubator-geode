/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
   
   
package com.gemstone.gemfire.internal.admin.remote;

import com.gemstone.gemfire.distributed.internal.*;
import com.gemstone.gemfire.internal.i18n.LocalizedStrings;

import java.io.*;

/**
 * A message that is sent to a particular distribution manager to
 * get its current information
 */
public final class FetchHostRequest extends AdminRequest {
  /**
   * Returns a <code>FetchHostRequest</code> to be sent to the specified recipient.
   */
  public static FetchHostRequest create() {
    FetchHostRequest m = new FetchHostRequest();
    return m;
  }

  public FetchHostRequest() {
    friendlyName = LocalizedStrings.FetchHostRequest_FETCH_REMOTE_HOST.toLocalizedString();
  }

  /**
   * Must return a proper response to this request.
   */
  @Override  
  protected AdminResponse createResponse(DistributionManager dm) {
    return FetchHostResponse.create(dm, this.getSender()); 
  }

  public int getDSFID() {
    return FETCH_HOST_REQUEST;
  }

  @Override  
  public void toData(DataOutput out) throws IOException {
    super.toData(out);
  }

  @Override  
  public void fromData(DataInput in)
    throws IOException, ClassNotFoundException {
    super.fromData(in);
  }

  @Override  
  public String toString() {
    return LocalizedStrings.FetchHostRequest_FETCHHOSTREQUEST_FOR_0.toLocalizedString(this.getRecipient());
  }
}