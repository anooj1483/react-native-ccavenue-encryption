#import "CcavenueEncryption.h"
#import "CCTool.h"


@implementation CcavenueEncryption

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(sampleMethod:(NSString *)stringArgument numberParameter:(nonnull NSNumber *)numberArgument callback:(RCTResponseSenderBlock)callback)
{
    // TODO: Implement some actually useful functionality
    callback(@[[NSString stringWithFormat: @"numberArgument: %@ stringArgument: %@", numberArgument, stringArgument]]);
}

RCT_REMAP_METHOD(encrypt,myRequestString:(NSString *)myRequestString  rsaKeyData:(NSString *)rsaKeyData
                 findEventsWithResolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
     CCTool *ccTool = [[CCTool alloc] init];
        
        
    //    rsaKey = [rsaKey stringByTrimmingCharactersInSet:[NSCharacterSet newlineCharacterSet]];
        NSString *key = [NSString stringWithFormat:@"-----BEGIN PUBLIC KEY-----\n%@\n-----END PUBLIC KEY-----\n",rsaKeyData];
        NSString *encVal = [ccTool encryptRSA:myRequestString key:key];
        resolve(encVal);
    
}

@end
