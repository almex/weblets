/*
 * Copyright 2005 John R. Fallows
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.java.dev.weblets;

import java.io.IOException;
import java.io.OutputStream;

public interface WebletResponse
{
  static public final int SC_ACCEPTED  = 0;
  static public final int SC_NOT_FOUND = 1;

  public void setDefaultContentType(String contentTypeDefault);
  public String getDefaultContentType();

  public void setLastModified(long lastModified);
  public void setContentType(String contentType);
  public void setContentLength(int contentLength);
  public void setContentVersion(String contentVersion);

  public OutputStream getOutputStream() throws IOException;

  public void setStatus(int status);
}