/*
    Copyright 2013 Rustici Software

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.rusticisoftware.tincan.json;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rusticisoftware.tincan.TCAPIVersion;

import java.io.IOException;

/**
 * Interface to implement to provide JSON support for nesting of objects
 */
public interface JSON {
    public ObjectNode toJSONNode(TCAPIVersion version);
    public ObjectNode toJSONNode();
    public String toJSON(TCAPIVersion version, Boolean pretty);
    public String toJSON(TCAPIVersion version);
    public String toJSON(Boolean pretty);
    public String toJSON();
}
