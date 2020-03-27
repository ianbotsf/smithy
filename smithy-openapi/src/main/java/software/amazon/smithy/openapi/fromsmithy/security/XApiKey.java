/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.smithy.openapi.fromsmithy.security;

import java.util.Set;
import software.amazon.smithy.openapi.fromsmithy.Context;
import software.amazon.smithy.openapi.fromsmithy.SecuritySchemeConverter;
import software.amazon.smithy.openapi.model.SecurityScheme;
import software.amazon.smithy.utils.SetUtils;

/**
 * Uses an HTTP header named X-Api-Key that contains an API key.
 *
 * <p>This is compatible with Amazon API Gateway API key authorization.
 *
 * @see <a href="https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-api-key-source.html">API Gateway documentation</a>
 */
public final class XApiKey implements SecuritySchemeConverter {
    @Override
    public String getAuthSchemeName() {
        return "http-x-api-key";
    }

    @Override
    public SecurityScheme createSecurityScheme(Context context) {
        return SecurityScheme.builder()
                .type("apiKey")
                .in("header")
                .name("x-api-key")
                .description("X-Api-Key authentication")
                .build();
    }

    @Override
    public Set<String> getAuthRequestHeaders() {
        return SetUtils.of("x-api-key");
    }
}
