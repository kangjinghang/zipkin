/*
 * Copyright 2015-2020 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin2.codec;

import java.util.List;

/**
 * Utility for encoding one or more elements of a type into a byte array.
 *
 * @param <T> type of the object to encode
 */
public interface BytesEncoder<T> { // Span 的编码器，将 Span 编码成二进制，便于 sender 发送给 Zipkin
  Encoding encoding();

  int sizeInBytes(T input);

  /** Serializes an object into its binary form. */
  byte[] encode(T input);

  /** Serializes a list of objects into their binary form. */
  byte[] encodeList(List<T> input);
}
