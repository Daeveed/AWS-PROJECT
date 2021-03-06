//
// Copyright 2016 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.13
//
package com.amazonaws.mobile;

import com.amazonaws.regions.Regions;

/**
 * This class defines constants for the developer's resource
 * identifiers and API keys. This configuration should not
 * be shared or posted to any public source code repository.
 */
public class AWSConfiguration {
    // AWS MobileHub user agent string
    public static final String AWS_MOBILEHUB_USER_AGENT =
        "MobileHub e22cd84c-b187-4cf7-9bda-832e7c8a2b68 aws-my-sample-app-android-v0.13";
    // AMAZON COGNITO
    public static final Regions AMAZON_COGNITO_REGION =
      Regions.fromName("us-east-1");
    public static final String  AMAZON_COGNITO_IDENTITY_POOL_ID =
        "us-east-1:7df972cf-1caf-4e32-add6-d67ee8eba219";
    // AMAZON MOBILE ANALYTICS
    public static final String  AMAZON_MOBILE_ANALYTICS_APP_ID =
        "baeae496f4e7459bac78057e8e534cde";
    // Amazon Mobile Analytics region
    public static final Regions AMAZON_MOBILE_ANALYTICS_REGION = Regions.US_EAST_1;
    // GOOGLE CLOUD MESSAGING SENDER ID
    public static final String GOOGLE_CLOUD_MESSAGING_SENDER_ID =
        "364713117563";
    public static final Regions AMAZON_DYNAMODB_REGION =
       Regions.fromName("us-east-1");
    public static final String AMAZON_COGNITO_USER_POOL_ID =
        "us-east-1_F8OM3VewN";
    public static final String AMAZON_COGNITO_USER_POOL_CLIENT_ID =
        "32fjrudnj844enq52vrb733vi2";
    public static final String AMAZON_COGNITO_USER_POOL_CLIENT_SECRET =
        "iinpvvp2mhq51rnktvffvonslj48sanvgvcnffii4aaha91vq73";
}
