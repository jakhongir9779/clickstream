#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class ClickstreamClickstreamConfig, ClickstreamClickstreamSdk, ClickstreamDataForPeriodicJob, ClickstreamClickstreamEvent, ClickstreamClickstreamBuilder, ClickstreamCommonAnalyticsBuilder, ClickstreamUiPropertiesAction, ClickstreamEventProperties, ClickstreamEventPropertiesBuilder, ClickstreamGroupBuilder, ClickstreamGroup, ClickstreamSectionBuilder, ClickstreamSection, ClickstreamSpaceBuilder, ClickstreamSpace, ClickstreamWidgetBuilder, ClickstreamWidget, ClickstreamUiPropertiesCompanion, ClickstreamUiProperties, ClickstreamKotlinEnumCompanion, ClickstreamKotlinEnum<E>, ClickstreamKotlinArray<T>, ClickstreamGroupCompanion, ClickstreamClickstreamGroupMarker, ClickstreamEventPropertiesCompanion, ClickstreamKotlinx_serialization_jsonJsonElement, ClickstreamClickstreamEventProperties, ClickstreamSectionCompanion, ClickstreamClickstreamSectionMarker, ClickstreamSpaceCompanion, ClickstreamSpaceType, ClickstreamClickstreamSpaceMarker, ClickstreamWidgetCompanion, ClickstreamWidgetType, ClickstreamClickstreamWidgetBuilder, ClickstreamWidgetButton, ClickstreamWidgetImage, ClickstreamWidgetInput, ClickstreamWidgetSelect, ClickstreamWidgetText, ClickstreamEventResult, ClickstreamEventResultFailed, ClickstreamEventResultSucceed, ClickstreamDatabaseEventSnapshotEntity, ClickstreamGetUnDispatchedEvents, ClickstreamClickstreamEventCompanion, ClickstreamExposureExperiment, ClickstreamApplicationAnalyticsPropertyProvider, ClickstreamUserAnalyticsPropertyProvider, ClickstreamDeviceAnalyticsPropertyProvider, ClickstreamPropertiesProviderCompanion, ClickstreamApplicationAnalyticsPropertyProviderCompanion, ClickstreamDeviceAnalyticsPropertyProviderCompanion, ClickstreamUserAnalyticsPropertyProviderCompanion, ClickstreamInstallIdPropertiesCompanion, ClickstreamPropertiesProvider, ClickstreamKotlinx_serialization_jsonJsonElementCompanion, ClickstreamDatabaseEventSnapshotEntityCompanion, ClickstreamKotlinThrowable, ClickstreamKotlinException, ClickstreamKotlinRuntimeException, ClickstreamKotlinIllegalStateException, ClickstreamSettingsPlatformSettings, ClickstreamKotlinx_serialization_coreSerializersModule, ClickstreamKotlinx_serialization_coreSerialKind, ClickstreamKotlinNothing, ClickstreamSettingsClickStreamSettings, ClickstreamSettingsEventPropertiesSettings, ClickstreamPlatformPlatformConnectionType, ClickstreamPlatformEventPropertiesDelegate, ClickstreamRuntimeTransacterTransaction, ClickstreamPlatformEventAdditionalProperties, ClickstreamPlatformViewId, ClickstreamKotlinByteArray, ClickstreamKotlinByteIterator;

@protocol ClickstreamKotlinx_coroutines_coreCoroutineScope, ClickstreamCommonAnalyticsEventSender, ClickstreamKotlinComparable, ClickstreamKotlinx_serialization_coreKSerializer, ClickstreamDatabaseLocalEventsGateway, ClickstreamClickstreamRemoteGateway, ClickstreamEventEvent, ClickstreamAnalyticsPropertyValue, ClickstreamAnalyticsPropertyProvider, ClickstreamApplicationAnalyticsProperties, ClickstreamDeviceAnalyticsProperties, ClickstreamUserAnalyticsProperties, ClickstreamInstallIdProperties, ClickstreamPlatformPlatformDependencies, ClickstreamKotlinCoroutineContext, ClickstreamKotlinIterator, ClickstreamKotlinx_serialization_coreEncoder, ClickstreamKotlinx_serialization_coreSerialDescriptor, ClickstreamKotlinx_serialization_coreSerializationStrategy, ClickstreamKotlinx_serialization_coreDecoder, ClickstreamKotlinx_serialization_coreDeserializationStrategy, ClickstreamDatabasePlatformDriverFactory, ClickstreamPlatformPlatformUtils, ClickstreamKotlinCoroutineContextElement, ClickstreamKotlinCoroutineContextKey, ClickstreamKotlinx_serialization_coreCompositeEncoder, ClickstreamKotlinAnnotation, ClickstreamKotlinx_serialization_coreCompositeDecoder, ClickstreamRuntimeSqlDriver, ClickstreamKotlinx_serialization_coreSerializersModuleCollector, ClickstreamKotlinKClass, ClickstreamRuntimeQueryListener, ClickstreamRuntimeQueryResult, ClickstreamRuntimeSqlPreparedStatement, ClickstreamRuntimeSqlCursor, ClickstreamRuntimeCloseable, ClickstreamMultiplatform_settingsSettings, ClickstreamKotlinKDeclarationContainer, ClickstreamKotlinKAnnotatedElement, ClickstreamKotlinKClassifier, ClickstreamRuntimeTransactionCallbacks;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface ClickstreamBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface ClickstreamBase (ClickstreamBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface ClickstreamMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface ClickstreamMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorClickstreamKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface ClickstreamNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface ClickstreamByte : ClickstreamNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface ClickstreamUByte : ClickstreamNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface ClickstreamShort : ClickstreamNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface ClickstreamUShort : ClickstreamNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface ClickstreamInt : ClickstreamNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface ClickstreamUInt : ClickstreamNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface ClickstreamLong : ClickstreamNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface ClickstreamULong : ClickstreamNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface ClickstreamFloat : ClickstreamNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface ClickstreamDouble : ClickstreamNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface ClickstreamBoolean : ClickstreamNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AnalyticsJobScheduler")))
@interface ClickstreamAnalyticsJobScheduler : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)doInitClickStreamConfig:(ClickstreamClickstreamConfig *)clickStreamConfig __attribute__((swift_name("doInit(clickStreamConfig:)")));
- (void)startWorkCoroutineScope:(id<ClickstreamKotlinx_coroutines_coreCoroutineScope>)coroutineScope __attribute__((swift_name("startWork(coroutineScope:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickstreamConfig")))
@interface ClickstreamClickstreamConfig : ClickstreamBase
- (instancetype)initWithSizeOfBatch:(int64_t)sizeOfBatch sendDataPeriodicityInMinutes:(double)sendDataPeriodicityInMinutes __attribute__((swift_name("init(sizeOfBatch:sendDataPeriodicityInMinutes:)"))) __attribute__((objc_designated_initializer));
@property (readonly) double sendDataPeriodicityInMinutes __attribute__((swift_name("sendDataPeriodicityInMinutes")));
@property (readonly) int64_t sizeOfBatch __attribute__((swift_name("sizeOfBatch")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickstreamSdk")))
@interface ClickstreamClickstreamSdk : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)clickstreamSdk __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamClickstreamSdk *shared __attribute__((swift_name("shared")));
- (void)exposureExperimentId:(NSString *)experimentId variantId:(NSString *)variantId exposedAt:(NSString *)exposedAt __attribute__((swift_name("exposure(experimentId:variantId:exposedAt:)")));
- (ClickstreamDataForPeriodicJob *)getDataForPeriodicJob __attribute__((swift_name("getDataForPeriodicJob()")));
- (void)sendBuilder:(ClickstreamClickstreamEvent *(^)(ClickstreamClickstreamBuilder *))builder __attribute__((swift_name("send(builder:)")));
- (id<ClickstreamCommonAnalyticsEventSender>)sender __attribute__((swift_name("sender()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExponentialBackoffStrategy")))
@interface ClickstreamExponentialBackoffStrategy : ClickstreamBase
- (instancetype)initWithMaxRetries:(int32_t)maxRetries initialDelayMillis:(int64_t)initialDelayMillis __attribute__((swift_name("init(maxRetries:initialDelayMillis:)"))) __attribute__((objc_designated_initializer));
- (void)dropBackoff __attribute__((swift_name("dropBackoff()")));
- (int64_t)getMillis __attribute__((swift_name("getMillis()")));
@end

__attribute__((swift_name("CommonAnalyticsBuilder")))
@interface ClickstreamCommonAnalyticsBuilder : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickstreamBuilder")))
@interface ClickstreamClickstreamBuilder : ClickstreamCommonAnalyticsBuilder
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (ClickstreamClickstreamBuilder *)actionAction:(ClickstreamUiPropertiesAction *)action __attribute__((swift_name("action(action:)")));
- (ClickstreamClickstreamEvent *)build __attribute__((swift_name("build()")));
- (ClickstreamClickstreamBuilder *)eventBuilder:(ClickstreamEventProperties *(^)(ClickstreamEventPropertiesBuilder *))builder __attribute__((swift_name("event(builder:)")));
- (ClickstreamGroupBuilder *)groupBuild:(ClickstreamGroup *(^)(ClickstreamGroupBuilder *))build __attribute__((swift_name("group(build:)")));
- (ClickstreamClickstreamBuilder *)interactionIsInteractive:(BOOL)isInteractive __attribute__((swift_name("interaction(isInteractive:)")));
- (ClickstreamSectionBuilder *)sectionBuild:(ClickstreamSection *(^)(ClickstreamSectionBuilder *))build __attribute__((swift_name("section(build:)")));
- (ClickstreamSpaceBuilder *)spaceBuild:(ClickstreamSpace *(^)(ClickstreamSpaceBuilder *))build __attribute__((swift_name("space(build:)")));
- (ClickstreamWidgetBuilder *)widgetBuild:(ClickstreamWidget *(^)(ClickstreamWidgetBuilder *))build __attribute__((swift_name("widget(build:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiProperties")))
@interface ClickstreamUiProperties : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamUiPropertiesCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamUiProperties *)doCopyWidget:(ClickstreamWidget * _Nullable)widget space:(ClickstreamSpace * _Nullable)space section:(ClickstreamSection * _Nullable)section group:(ClickstreamGroup * _Nullable)group action:(ClickstreamUiPropertiesAction * _Nullable)action __attribute__((swift_name("doCopy(widget:space:section:group:action:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClickstreamUiPropertiesAction * _Nullable action __attribute__((swift_name("action")));
@property (readonly) ClickstreamGroup * _Nullable group __attribute__((swift_name("group")));
@property (readonly) ClickstreamSection * _Nullable section __attribute__((swift_name("section")));
@property (readonly) ClickstreamSpace * _Nullable space __attribute__((swift_name("space")));
@property (readonly) ClickstreamWidget * _Nullable widget __attribute__((swift_name("widget")));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol ClickstreamKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface ClickstreamKotlinEnum<E> : ClickstreamBase <ClickstreamKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClickstreamKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiProperties.Action")))
@interface ClickstreamUiPropertiesAction : ClickstreamKotlinEnum<ClickstreamUiPropertiesAction *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClickstreamUiPropertiesAction *show __attribute__((swift_name("show")));
@property (class, readonly) ClickstreamUiPropertiesAction *click __attribute__((swift_name("click")));
@property (class, readonly) ClickstreamUiPropertiesAction *swipe __attribute__((swift_name("swipe")));
@property (class, readonly) ClickstreamUiPropertiesAction *input __attribute__((swift_name("input")));
@property (class, readonly) ClickstreamUiPropertiesAction *autoInput __attribute__((swift_name("autoInput")));
@property (class, readonly) ClickstreamUiPropertiesAction *submit __attribute__((swift_name("submit")));
@property (class, readonly) ClickstreamUiPropertiesAction *slide __attribute__((swift_name("slide")));
@property (class, readonly) ClickstreamUiPropertiesAction *drag __attribute__((swift_name("drag")));
@property (class, readonly) ClickstreamUiPropertiesAction *scroll __attribute__((swift_name("scroll")));
@property (class, readonly) ClickstreamUiPropertiesAction *spaceOpen __attribute__((swift_name("spaceOpen")));
+ (ClickstreamKotlinArray<ClickstreamUiPropertiesAction *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClickstreamUiPropertiesAction *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiProperties.Companion")))
@interface ClickstreamUiPropertiesCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamUiPropertiesCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("ClickstreamGroupMarker")))
@interface ClickstreamClickstreamGroupMarker : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Group")))
@interface ClickstreamGroup : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamGroupCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamGroup *)doCopyName:(NSString *)name position:(ClickstreamLong * _Nullable)position __attribute__((swift_name("doCopy(name:position:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamLong * _Nullable position __attribute__((swift_name("position")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Group.Companion")))
@interface ClickstreamGroupCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamGroupCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GroupBuilder")))
@interface ClickstreamGroupBuilder : ClickstreamClickstreamGroupMarker
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (ClickstreamGroup *)nameName:(NSString *)name __attribute__((swift_name("name(name:)")));
- (ClickstreamGroup *)positionPosition:(int32_t)position __attribute__((swift_name("position(int32:)")));
- (ClickstreamGroup *)positionPosition_:(int64_t)position __attribute__((swift_name("position(int:)")));
@end

__attribute__((swift_name("ClickstreamEventProperties")))
@interface ClickstreamClickstreamEventProperties : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventProperties")))
@interface ClickstreamEventProperties : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamEventPropertiesCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamEventProperties *)doCopyType:(NSString *)type parameters:(NSDictionary<NSString *, ClickstreamKotlinx_serialization_jsonJsonElement *> *)parameters __attribute__((swift_name("doCopy(type:parameters:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSDictionary<NSString *, ClickstreamKotlinx_serialization_jsonJsonElement *> *parameters __attribute__((swift_name("parameters")));
@property (readonly) NSString *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventProperties.Companion")))
@interface ClickstreamEventPropertiesCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamEventPropertiesCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventPropertiesBuilder")))
@interface ClickstreamEventPropertiesBuilder : ClickstreamClickstreamEventProperties
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (ClickstreamEventProperties *)addIfNotNilKey:(NSString *)key value:(ClickstreamDouble * _Nullable)value __attribute__((swift_name("addIfNotNil(key:double:)")));
- (ClickstreamEventProperties *)addIfNotNilKey:(NSString *)key value_:(ClickstreamInt * _Nullable)value __attribute__((swift_name("addIfNotNil(key:int32:)")));
- (ClickstreamEventProperties *)addIfNotNilKey:(NSString *)key value__:(ClickstreamLong * _Nullable)value __attribute__((swift_name("addIfNotNil(key:int:)")));
- (ClickstreamEventProperties *)addIfNotNilKey:(NSString *)key value___:(NSString * _Nullable)value __attribute__((swift_name("addIfNotNil(key:string:)")));
- (ClickstreamEventProperties *)parameterKey:(NSString *)key value:(BOOL)value __attribute__((swift_name("parameter(key:bool:)")));
- (ClickstreamEventProperties *)parameterKey:(NSString *)key value_:(double)value __attribute__((swift_name("parameter(key:double:)")));
- (ClickstreamEventProperties *)parameterKey:(NSString *)key value__:(int32_t)value __attribute__((swift_name("parameter(key:int32:)")));
- (ClickstreamEventProperties *)parameterKey:(NSString *)key value___:(int64_t)value __attribute__((swift_name("parameter(key:int:)")));
- (ClickstreamEventProperties *)parameterKey:(NSString *)key value____:(NSString *)value __attribute__((swift_name("parameter(key:string:)")));
- (ClickstreamEventProperties *)parameterKey:(NSString *)key value_____:(NSArray<ClickstreamLong *> *)value __attribute__((swift_name("parameter(key:intArray:)")));
- (ClickstreamEventProperties *)typeType:(NSString *)type __attribute__((swift_name("type(type:)")));
@end

__attribute__((swift_name("ClickstreamSectionMarker")))
@interface ClickstreamClickstreamSectionMarker : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Section")))
@interface ClickstreamSection : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamSectionCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamSection *)doCopyId:(NSString * _Nullable)id type:(NSString * _Nullable)type name:(NSString *)name position:(ClickstreamLong * _Nullable)position __attribute__((swift_name("doCopy(id:type:name:position:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable id __attribute__((swift_name("id")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamLong * _Nullable position __attribute__((swift_name("position")));
@property (readonly) NSString * _Nullable type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Section.Companion")))
@interface ClickstreamSectionCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamSectionCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SectionBuilder")))
@interface ClickstreamSectionBuilder : ClickstreamClickstreamSectionMarker
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (ClickstreamSection *)idId:(int32_t)id __attribute__((swift_name("id(int32:)")));
- (ClickstreamSection *)idId_:(int64_t)id __attribute__((swift_name("id(int:)")));
- (ClickstreamSection *)idId__:(NSString *)id __attribute__((swift_name("id(string:)")));
- (ClickstreamSection *)nameName:(NSString *)name __attribute__((swift_name("name(name:)")));
- (ClickstreamSection *)positionPosition:(int32_t)position __attribute__((swift_name("position(int32:)")));
- (ClickstreamSection *)positionPosition_:(int64_t)position __attribute__((swift_name("position(int:)")));
- (ClickstreamSection *)typeType:(NSString * _Nullable)type __attribute__((swift_name("type(type:)")));
@end

__attribute__((swift_name("ClickstreamSpaceMarker")))
@interface ClickstreamClickstreamSpaceMarker : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Space")))
@interface ClickstreamSpace : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamSpaceCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamSpace *)doCopyId:(NSString * _Nullable)id name:(NSString *)name type:(ClickstreamSpaceType *)type screenSize:(NSString *)screenSize __attribute__((swift_name("doCopy(id:name:type:screenSize:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable id __attribute__((swift_name("id")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *screenSize __attribute__((swift_name("screenSize")));
@property (readonly) ClickstreamSpaceType *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Space.Companion")))
@interface ClickstreamSpaceCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamSpaceCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Space.Types")))
@interface ClickstreamSpaceType : ClickstreamKotlinEnum<ClickstreamSpaceType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClickstreamSpaceType *page __attribute__((swift_name("page")));
@property (class, readonly) ClickstreamSpaceType *modal __attribute__((swift_name("modal")));
+ (ClickstreamKotlinArray<ClickstreamSpaceType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClickstreamSpaceType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SpaceBuilder")))
@interface ClickstreamSpaceBuilder : ClickstreamClickstreamSpaceMarker
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (ClickstreamSpace *)idId:(int32_t)id __attribute__((swift_name("id(int32:)")));
- (ClickstreamSpace *)idId_:(int64_t)id __attribute__((swift_name("id(int:)")));
- (ClickstreamSpace *)idId__:(NSString *)id __attribute__((swift_name("id(string:)")));
- (ClickstreamSpace *)nameName:(NSString *)name __attribute__((swift_name("name(name:)")));
- (ClickstreamSpace *)screenSizeScreenSize:(NSString *)screenSize __attribute__((swift_name("screenSize(screenSize:)")));
- (ClickstreamSpace *)typeType:(ClickstreamSpaceType *)type __attribute__((swift_name("type(type:)")));
@end

__attribute__((swift_name("ClickstreamWidgetBuilder")))
@interface ClickstreamClickstreamWidgetBuilder : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((swift_name("Widget")))
@interface ClickstreamWidget : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamWidgetCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamWidgetType *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Button")))
@interface ClickstreamWidgetButton : ClickstreamWidget
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamInt * _Nullable position __attribute__((swift_name("position")));
@property (readonly) NSString *text __attribute__((swift_name("text")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Companion")))
@interface ClickstreamWidgetCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamWidgetCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClickstreamKotlinArray<id<ClickstreamKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Image")))
@interface ClickstreamWidgetImage : ClickstreamWidget
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamInt * _Nullable position __attribute__((swift_name("position")));
@property (readonly) NSString *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Input")))
@interface ClickstreamWidgetInput : ClickstreamWidget
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamInt * _Nullable position __attribute__((swift_name("position")));
@property (readonly) NSString * _Nullable prompt __attribute__((swift_name("prompt")));
@property (readonly) NSString *text __attribute__((swift_name("text")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Select")))
@interface ClickstreamWidgetSelect : ClickstreamWidget
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamInt * _Nullable position __attribute__((swift_name("position")));
@property (readonly) NSString *text __attribute__((swift_name("text")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Text")))
@interface ClickstreamWidgetText : ClickstreamWidget
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) ClickstreamInt * _Nullable position __attribute__((swift_name("position")));
@property (readonly) NSString *text __attribute__((swift_name("text")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Widget.Type_")))
@interface ClickstreamWidgetType : ClickstreamKotlinEnum<ClickstreamWidgetType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClickstreamWidgetType *button __attribute__((swift_name("button")));
@property (class, readonly) ClickstreamWidgetType *image __attribute__((swift_name("image")));
@property (class, readonly) ClickstreamWidgetType *video __attribute__((swift_name("video")));
@property (class, readonly) ClickstreamWidgetType *input __attribute__((swift_name("input")));
@property (class, readonly) ClickstreamWidgetType *select __attribute__((swift_name("select")));
@property (class, readonly) ClickstreamWidgetType *text __attribute__((swift_name("text")));
+ (ClickstreamKotlinArray<ClickstreamWidgetType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClickstreamWidgetType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("WidgetBuilder")))
@interface ClickstreamWidgetBuilder : ClickstreamClickstreamWidgetBuilder
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (ClickstreamWidgetButton *)buttonName:(NSString *)name text:(NSString *)text position:(ClickstreamInt * _Nullable)position __attribute__((swift_name("button(name:text:position:)")));
- (ClickstreamWidgetImage *)imageName:(NSString *)name url:(NSString *)url position:(ClickstreamInt * _Nullable)position __attribute__((swift_name("image(name:url:position:)")));
- (ClickstreamWidgetInput *)inputName:(NSString *)name text:(NSString *)text prompt:(NSString * _Nullable)prompt position:(ClickstreamInt * _Nullable)position __attribute__((swift_name("input(name:text:prompt:position:)")));
- (ClickstreamWidgetSelect *)selectName:(NSString *)name text:(NSString *)text position:(ClickstreamInt * _Nullable)position __attribute__((swift_name("select(name:text:position:)")));
- (ClickstreamWidgetText *)textName:(NSString *)name text:(NSString *)text position:(ClickstreamInt * _Nullable)position __attribute__((swift_name("text(name:text:position:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DataForPeriodicJob")))
@interface ClickstreamDataForPeriodicJob : ClickstreamBase
- (instancetype)initWithLocalEventsGateway:(id<ClickstreamDatabaseLocalEventsGateway>)localEventsGateway remoteGateway:(id<ClickstreamClickstreamRemoteGateway>)remoteGateway clickstreamConfig:(ClickstreamClickstreamConfig *)clickstreamConfig __attribute__((swift_name("init(localEventsGateway:remoteGateway:clickstreamConfig:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamDataForPeriodicJob *)doCopyLocalEventsGateway:(id<ClickstreamDatabaseLocalEventsGateway>)localEventsGateway remoteGateway:(id<ClickstreamClickstreamRemoteGateway>)remoteGateway clickstreamConfig:(ClickstreamClickstreamConfig *)clickstreamConfig __attribute__((swift_name("doCopy(localEventsGateway:remoteGateway:clickstreamConfig:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClickstreamClickstreamConfig *clickstreamConfig __attribute__((swift_name("clickstreamConfig")));
@property (readonly) id<ClickstreamDatabaseLocalEventsGateway> localEventsGateway __attribute__((swift_name("localEventsGateway")));
@property (readonly) id<ClickstreamClickstreamRemoteGateway> remoteGateway __attribute__((swift_name("remoteGateway")));
@end

__attribute__((swift_name("EventResult")))
@interface ClickstreamEventResult : ClickstreamBase
@property (readonly) int64_t id __attribute__((swift_name("id")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventResult.Failed")))
@interface ClickstreamEventResultFailed : ClickstreamEventResult
- (instancetype)initWithId:(int64_t)id __attribute__((swift_name("init(id:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamEventResultFailed *)doCopyId:(int64_t)id __attribute__((swift_name("doCopy(id:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t id __attribute__((swift_name("id")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventResult.Succeed")))
@interface ClickstreamEventResultSucceed : ClickstreamEventResult
- (instancetype)initWithId:(int64_t)id __attribute__((swift_name("init(id:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamEventResultSucceed *)doCopyId:(int64_t)id __attribute__((swift_name("doCopy(id:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t id __attribute__((swift_name("id")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GetUnDispatchedEvents")))
@interface ClickstreamGetUnDispatchedEvents : ClickstreamBase
- (instancetype)initWithLocalEventsGateway:(id<ClickstreamDatabaseLocalEventsGateway>)localEventsGateway clickstreamConfig:(ClickstreamClickstreamConfig *)clickstreamConfig __attribute__((swift_name("init(localEventsGateway:clickstreamConfig:)"))) __attribute__((objc_designated_initializer));
- (NSArray<ClickstreamDatabaseEventSnapshotEntity *> *)invoke __attribute__((swift_name("invoke()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SendBatchOfEventsToClickstream")))
@interface ClickstreamSendBatchOfEventsToClickstream : ClickstreamBase
- (instancetype)initWithLocalEventsGateway:(id<ClickstreamDatabaseLocalEventsGateway>)localEventsGateway clickstreamRemoteGateway:(id<ClickstreamClickstreamRemoteGateway>)clickstreamRemoteGateway getUnDispatchedEvents:(ClickstreamGetUnDispatchedEvents *)getUnDispatchedEvents __attribute__((swift_name("init(localEventsGateway:clickstreamRemoteGateway:getUnDispatchedEvents:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeWithCompletionHandler:(void (^)(NSArray<ClickstreamEventResult *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(completionHandler:)")));
@end

__attribute__((swift_name("EventEvent")))
@protocol ClickstreamEventEvent
@required
@property (readonly) NSString *analyticsType __attribute__((swift_name("analyticsType")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickstreamEvent")))
@interface ClickstreamClickstreamEvent : ClickstreamBase <ClickstreamEventEvent>
@property (class, readonly, getter=companion) ClickstreamClickstreamEventCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamClickstreamEvent *)doCopyEventProperties:(ClickstreamEventProperties * _Nullable)eventProperties uiProperties:(ClickstreamUiProperties * _Nullable)uiProperties isInteractive:(BOOL)isInteractive __attribute__((swift_name("doCopy(eventProperties:uiProperties:isInteractive:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *analyticsType __attribute__((swift_name("analyticsType")));
@property (readonly) ClickstreamEventProperties * _Nullable eventProperties __attribute__((swift_name("eventProperties")));
@property (readonly) BOOL isInteractive __attribute__((swift_name("isInteractive")));
@property (readonly) ClickstreamUiProperties * _Nullable uiProperties __attribute__((swift_name("uiProperties")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickstreamEvent.Companion")))
@interface ClickstreamClickstreamEventCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamClickstreamEventCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExposureExperiment")))
@interface ClickstreamExposureExperiment : ClickstreamBase
- (instancetype)initWithExperimentId:(NSString *)experimentId variantId:(NSString *)variantId exposedAt:(NSString *)exposedAt accountId:(NSString *)accountId __attribute__((swift_name("init(experimentId:variantId:exposedAt:accountId:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamExposureExperiment *)doCopyExperimentId:(NSString *)experimentId variantId:(NSString *)variantId exposedAt:(NSString *)exposedAt accountId:(NSString *)accountId __attribute__((swift_name("doCopy(experimentId:variantId:exposedAt:accountId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *accountId __attribute__((swift_name("accountId")));
@property (readonly) NSString *experimentId __attribute__((swift_name("experimentId")));
@property (readonly) NSString *exposedAt __attribute__((swift_name("exposedAt")));
@property (readonly) NSString *variantId __attribute__((swift_name("variantId")));
@end

__attribute__((swift_name("ExposureExperimentsApi")))
@protocol ClickstreamExposureExperimentsApi
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeExperimentId:(NSString *)experimentId variantId:(NSString *)variantId exposedAt:(NSString *)exposedAt completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(experimentId:variantId:exposedAt:completionHandler:)")));
@end

__attribute__((swift_name("ClickstreamRemoteGateway")))
@protocol ClickstreamClickstreamRemoteGateway
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)sendEvents:(NSArray<ClickstreamDatabaseEventSnapshotEntity *> *)events completionHandler:(void (^)(NSArray<ClickstreamEventResult *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("send(events:completionHandler:)")));
@end

__attribute__((swift_name("AnalyticsPropertyProvider")))
@protocol ClickstreamAnalyticsPropertyProvider
@required
- (NSSet<id<ClickstreamAnalyticsPropertyValue>> *)properties __attribute__((swift_name("properties()")));
- (NSString *)toJsonValues __attribute__((swift_name("toJsonValues()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("AnalyticsPropertyValue")))
@protocol ClickstreamAnalyticsPropertyValue
@required
- (NSString * _Nullable)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PropertiesProvider")))
@interface ClickstreamPropertiesProvider : ClickstreamBase
- (instancetype)initWithAppProps:(ClickstreamApplicationAnalyticsPropertyProvider *)appProps userProps:(ClickstreamUserAnalyticsPropertyProvider *)userProps deviceProps:(ClickstreamDeviceAnalyticsPropertyProvider *)deviceProps __attribute__((swift_name("init(appProps:userProps:deviceProps:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClickstreamPropertiesProviderCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClickstreamApplicationAnalyticsPropertyProvider *appProps __attribute__((swift_name("appProps")));
@property (readonly) ClickstreamDeviceAnalyticsPropertyProvider *deviceProps __attribute__((swift_name("deviceProps")));
@property (readonly) ClickstreamUserAnalyticsPropertyProvider *userProps __attribute__((swift_name("userProps")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PropertiesProvider.Companion")))
@interface ClickstreamPropertiesProviderCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamPropertiesProviderCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("ApplicationAnalyticsProperties")))
@protocol ClickstreamApplicationAnalyticsProperties <ClickstreamAnalyticsPropertyValue>
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ApplicationAnalyticsPropertyProvider")))
@interface ClickstreamApplicationAnalyticsPropertyProvider : ClickstreamBase <ClickstreamAnalyticsPropertyProvider>
- (instancetype)initWithValues:(NSSet<id<ClickstreamApplicationAnalyticsProperties>> *)values __attribute__((swift_name("init(values:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClickstreamApplicationAnalyticsPropertyProviderCompanion *companion __attribute__((swift_name("companion")));
- (NSSet<id<ClickstreamAnalyticsPropertyValue>> *)properties __attribute__((swift_name("properties()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ApplicationAnalyticsPropertyProvider.Companion")))
@interface ClickstreamApplicationAnalyticsPropertyProviderCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamApplicationAnalyticsPropertyProviderCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppVersionProperty")))
@interface ClickstreamAppVersionProperty : ClickstreamBase
- (instancetype)initWithVersion:(NSString *)version __attribute__((swift_name("init(version:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("DeviceAnalyticsProperties")))
@protocol ClickstreamDeviceAnalyticsProperties <ClickstreamAnalyticsPropertyValue>
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DeviceAnalyticsPropertyProvider")))
@interface ClickstreamDeviceAnalyticsPropertyProvider : ClickstreamBase <ClickstreamAnalyticsPropertyProvider>
- (instancetype)initWithValues:(NSSet<id<ClickstreamDeviceAnalyticsProperties>> *)values __attribute__((swift_name("init(values:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClickstreamDeviceAnalyticsPropertyProviderCompanion *companion __attribute__((swift_name("companion")));
- (NSSet<id<ClickstreamAnalyticsPropertyValue>> *)properties __attribute__((swift_name("properties()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DeviceAnalyticsPropertyProvider.Companion")))
@interface ClickstreamDeviceAnalyticsPropertyProviderCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamDeviceAnalyticsPropertyProviderCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppMetricaDeviceIdProperty")))
@interface ClickstreamAppMetricaDeviceIdProperty : ClickstreamBase <ClickstreamDeviceAnalyticsProperties>
- (instancetype)initWithAppMetricaDeviceId:(NSString *)appMetricaDeviceId __attribute__((swift_name("init(appMetricaDeviceId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("UserAnalyticsProperties")))
@protocol ClickstreamUserAnalyticsProperties <ClickstreamAnalyticsPropertyValue>
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserAnalyticsPropertyProvider")))
@interface ClickstreamUserAnalyticsPropertyProvider : ClickstreamBase <ClickstreamAnalyticsPropertyProvider>
- (instancetype)initWithValues:(NSSet<id<ClickstreamUserAnalyticsProperties>> *)values __attribute__((swift_name("init(values:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClickstreamUserAnalyticsPropertyProviderCompanion *companion __attribute__((swift_name("companion")));
- (NSSet<id<ClickstreamAnalyticsPropertyValue>> *)properties __attribute__((swift_name("properties()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserAnalyticsPropertyProvider.Companion")))
@interface ClickstreamUserAnalyticsPropertyProviderCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamUserAnalyticsPropertyProviderCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountIdProperty")))
@interface ClickstreamAccountIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithAccountId:(NSString *)accountId __attribute__((swift_name("init(accountId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppsflyerIdProperty")))
@interface ClickstreamAppsflyerIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithAppsflyerId:(NSString *)appsflyerId __attribute__((swift_name("init(appsflyerId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FacebookIdProperty")))
@interface ClickstreamFacebookIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithFacebookId:(NSString *)facebookId __attribute__((swift_name("init(facebookId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FirebaseAppInstanceIdProperty")))
@interface ClickstreamFirebaseAppInstanceIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithFirebaseAppInstanceId:(NSString *)firebaseAppInstanceId __attribute__((swift_name("init(firebaseAppInstanceId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GoogleCidProperty")))
@interface ClickstreamGoogleCidProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithGoogleCid:(NSString *)googleCid __attribute__((swift_name("init(googleCid:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("InstallIdProperties")))
@protocol ClickstreamInstallIdProperties <ClickstreamUserAnalyticsProperties>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("InstallIdPropertiesCompanion")))
@interface ClickstreamInstallIdPropertiesCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamInstallIdPropertiesCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *KEY __attribute__((swift_name("KEY")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("InstallIdProperty")))
@interface ClickstreamInstallIdProperty : ClickstreamBase <ClickstreamInstallIdProperties>
- (instancetype)initWithInstallId:(NSString *)installId __attribute__((swift_name("init(installId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LanguageProperty")))
@interface ClickstreamLanguageProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithLanguage:(NSString *)language __attribute__((swift_name("init(language:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MindboxAnonIdProperty")))
@interface ClickstreamMindboxAnonIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithMuid:(NSString *)muid __attribute__((swift_name("init(muid:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MindboxIdProperty")))
@interface ClickstreamMindboxIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithMindboxId:(NSString *)mindboxId __attribute__((swift_name("init(mindboxId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MyTrackerInstanceIdProperty")))
@interface ClickstreamMyTrackerInstanceIdProperty : ClickstreamBase <ClickstreamUserAnalyticsProperties>
- (instancetype)initWithMyTrackerInstanceId:(NSString *)myTrackerInstanceId __attribute__((swift_name("init(myTrackerInstanceId:)"))) __attribute__((objc_designated_initializer));
- (NSString *)getValue __attribute__((swift_name("getValue()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

@interface ClickstreamClickstreamSdk (Extensions)
- (void)initializeUrl:(NSString *)url requestHeaders:(NSDictionary<NSString *, NSString *(^)(void)> *)requestHeaders config:(ClickstreamClickstreamConfig *)config propertiesProvider:(ClickstreamPropertiesProvider * _Nullable)propertiesProvider __attribute__((swift_name("initialize(url:requestHeaders:config:propertiesProvider:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickStreamKt")))
@interface ClickstreamClickStreamKt : ClickstreamBase
@property (class, readonly) NSString *Clickstream __attribute__((swift_name("Clickstream")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClickStreamBuilderExtKt")))
@interface ClickstreamClickStreamBuilderExtKt : ClickstreamBase
+ (NSArray<id<ClickstreamEventEvent>> *)clickstream:(NSMutableArray<id<ClickstreamEventEvent>> *)receiver builder:(ClickstreamClickstreamEvent *(^)(ClickstreamClickstreamBuilder *))builder __attribute__((swift_name("clickstream(_:builder:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MergePropertiesWithDefaultKt")))
@interface ClickstreamMergePropertiesWithDefaultKt : ClickstreamBase
+ (ClickstreamPropertiesProvider *)mergePropertiesWithDefaultDependencies:(id<ClickstreamPlatformPlatformDependencies>)dependencies propertiesProvider:(ClickstreamPropertiesProvider * _Nullable)propertiesProvider __attribute__((swift_name("mergePropertiesWithDefault(dependencies:propertiesProvider:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol ClickstreamKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<ClickstreamKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end

__attribute__((swift_name("CommonAnalyticsEventSender")))
@protocol ClickstreamCommonAnalyticsEventSender
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)sendEvent:(id<ClickstreamEventEvent>)event completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("send(event:completionHandler:)")));
@property (readonly) NSString *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface ClickstreamKotlinEnumCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface ClickstreamKotlinArray<T> : ClickstreamBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(ClickstreamInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<ClickstreamKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol ClickstreamKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<ClickstreamKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<ClickstreamKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol ClickstreamKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<ClickstreamKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<ClickstreamKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol ClickstreamKotlinx_serialization_coreKSerializer <ClickstreamKotlinx_serialization_coreSerializationStrategy, ClickstreamKotlinx_serialization_coreDeserializationStrategy>
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/serialization/json/JsonElementSerializer))
*/
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement")))
@interface ClickstreamKotlinx_serialization_jsonJsonElement : ClickstreamBase
@property (class, readonly, getter=companion) ClickstreamKotlinx_serialization_jsonJsonElementCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((swift_name("DatabaseLocalEventsGateway")))
@protocol ClickstreamDatabaseLocalEventsGateway
@required
- (NSArray<ClickstreamDatabaseEventSnapshotEntity *> *)getAllByCountCount:(int32_t)count __attribute__((swift_name("getAllByCount(count:)")));
- (void)removeByIdsIds:(NSArray<ClickstreamLong *> *)ids __attribute__((swift_name("removeByIds(ids:)")));
- (void)saveEvent:(ClickstreamDatabaseEventSnapshotEntity *)event __attribute__((swift_name("save(event:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DatabaseEventSnapshotEntity")))
@interface ClickstreamDatabaseEventSnapshotEntity : ClickstreamBase
- (instancetype)initWithId:(int64_t)id event:(NSString *)event properties:(NSDictionary<NSString *, NSString *> *)properties propertyHash:(NSString *)propertyHash __attribute__((swift_name("init(id:event:properties:propertyHash:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClickstreamDatabaseEventSnapshotEntityCompanion *companion __attribute__((swift_name("companion")));
- (ClickstreamDatabaseEventSnapshotEntity *)doCopyId:(int64_t)id event:(NSString *)event properties:(NSDictionary<NSString *, NSString *> *)properties propertyHash:(NSString *)propertyHash __attribute__((swift_name("doCopy(id:event:properties:propertyHash:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *event __attribute__((swift_name("event")));
@property (readonly) int64_t id __attribute__((swift_name("id")));
@property (readonly) NSDictionary<NSString *, NSString *> *properties __attribute__((swift_name("properties")));
@property (readonly) NSString *propertyHash __attribute__((swift_name("propertyHash")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface ClickstreamKotlinThrowable : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (ClickstreamKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClickstreamKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface ClickstreamKotlinException : ClickstreamKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface ClickstreamKotlinRuntimeException : ClickstreamKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface ClickstreamKotlinIllegalStateException : ClickstreamKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface ClickstreamKotlinCancellationException : ClickstreamKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClickstreamKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("PlatformPlatformDependencies")))
@protocol ClickstreamPlatformPlatformDependencies
@required
@property (readonly) id<ClickstreamDatabasePlatformDriverFactory> databaseDriverFactory __attribute__((swift_name("databaseDriverFactory")));
@property (readonly) ClickstreamSettingsPlatformSettings *settings __attribute__((swift_name("settings")));
@property (readonly) id<ClickstreamPlatformPlatformUtils> utils __attribute__((swift_name("utils")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinCoroutineContext")))
@protocol ClickstreamKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<ClickstreamKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<ClickstreamKotlinCoroutineContextElement> _Nullable)getKey:(id<ClickstreamKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<ClickstreamKotlinCoroutineContext>)minusKeyKey:(id<ClickstreamKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<ClickstreamKotlinCoroutineContext>)plusContext:(id<ClickstreamKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol ClickstreamKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol ClickstreamKotlinx_serialization_coreEncoder
@required
- (id<ClickstreamKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<ClickstreamKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<ClickstreamKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<ClickstreamKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<ClickstreamKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) ClickstreamKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol ClickstreamKotlinx_serialization_coreSerialDescriptor
@required

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSArray<id<ClickstreamKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSArray<id<ClickstreamKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) ClickstreamKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol ClickstreamKotlinx_serialization_coreDecoder
@required
- (id<ClickstreamKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<ClickstreamKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (ClickstreamKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<ClickstreamKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<ClickstreamKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) ClickstreamKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement.Companion")))
@interface ClickstreamKotlinx_serialization_jsonJsonElementCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamKotlinx_serialization_jsonJsonElementCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DatabaseEventSnapshotEntity.Companion")))
@interface ClickstreamDatabaseEventSnapshotEntityCompanion : ClickstreamBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClickstreamDatabaseEventSnapshotEntityCompanion *shared __attribute__((swift_name("shared")));
- (id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("DatabasePlatformDriverFactory")))
@protocol ClickstreamDatabasePlatformDriverFactory
@required
- (id<ClickstreamRuntimeSqlDriver>)createDriver __attribute__((swift_name("createDriver()")));
@end

__attribute__((swift_name("SettingsPlatformSettings")))
@interface ClickstreamSettingsPlatformSettings : ClickstreamBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) ClickstreamSettingsClickStreamSettings *clickStream __attribute__((swift_name("clickStream")));
@property (readonly) ClickstreamSettingsEventPropertiesSettings *eventProperties __attribute__((swift_name("eventProperties")));
@end

__attribute__((swift_name("PlatformPlatformUtils")))
@protocol ClickstreamPlatformPlatformUtils
@required
- (int64_t)generateTimestamp __attribute__((swift_name("generateTimestamp()")));
- (NSString *)generateUUID __attribute__((swift_name("generateUUID()")));
- (NSString *)getAppPackage __attribute__((swift_name("getAppPackage()")));
- (NSString *)getAppVersion __attribute__((swift_name("getAppVersion()")));
- (ClickstreamPlatformPlatformConnectionType *)getConnectionType __attribute__((swift_name("getConnectionType()")));
- (NSString *)getTimezone __attribute__((swift_name("getTimezone()")));
- (BOOL)doInitAllowed __attribute__((swift_name("doInitAllowed()")));
- (void)subscribeOnSessionUpdateDelegate:(ClickstreamPlatformEventPropertiesDelegate *)delegate __attribute__((swift_name("subscribeOnSessionUpdate(delegate:)")));
@end

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol ClickstreamKotlinCoroutineContextElement <ClickstreamKotlinCoroutineContext>
@required
@property (readonly) id<ClickstreamKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol ClickstreamKotlinCoroutineContextKey
@required
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol ClickstreamKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<ClickstreamKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ClickstreamKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ClickstreamKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) ClickstreamKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface ClickstreamKotlinx_serialization_coreSerializersModule : ClickstreamBase

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<ClickstreamKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClickstreamKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<ClickstreamKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<ClickstreamKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClickstreamKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ClickstreamKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClickstreamKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ClickstreamKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol ClickstreamKotlinAnnotation
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface ClickstreamKotlinx_serialization_coreSerialKind : ClickstreamBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol ClickstreamKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<ClickstreamKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ClickstreamKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ClickstreamKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<ClickstreamKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) ClickstreamKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface ClickstreamKotlinNothing : ClickstreamBase
@end

__attribute__((swift_name("RuntimeCloseable")))
@protocol ClickstreamRuntimeCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end

__attribute__((swift_name("RuntimeSqlDriver")))
@protocol ClickstreamRuntimeSqlDriver <ClickstreamRuntimeCloseable>
@required
- (void)addListenerQueryKeys:(ClickstreamKotlinArray<NSString *> *)queryKeys listener:(id<ClickstreamRuntimeQueryListener>)listener __attribute__((swift_name("addListener(queryKeys:listener:)")));
- (ClickstreamRuntimeTransacterTransaction * _Nullable)currentTransaction __attribute__((swift_name("currentTransaction()")));
- (id<ClickstreamRuntimeQueryResult>)executeIdentifier:(ClickstreamInt * _Nullable)identifier sql:(NSString *)sql parameters:(int32_t)parameters binders:(void (^ _Nullable)(id<ClickstreamRuntimeSqlPreparedStatement>))binders __attribute__((swift_name("execute(identifier:sql:parameters:binders:)")));
- (id<ClickstreamRuntimeQueryResult>)executeQueryIdentifier:(ClickstreamInt * _Nullable)identifier sql:(NSString *)sql mapper:(id<ClickstreamRuntimeQueryResult> (^)(id<ClickstreamRuntimeSqlCursor>))mapper parameters:(int32_t)parameters binders:(void (^ _Nullable)(id<ClickstreamRuntimeSqlPreparedStatement>))binders __attribute__((swift_name("executeQuery(identifier:sql:mapper:parameters:binders:)")));
- (id<ClickstreamRuntimeQueryResult>)doNewTransaction __attribute__((swift_name("doNewTransaction()")));
- (void)notifyListenersQueryKeys:(ClickstreamKotlinArray<NSString *> *)queryKeys __attribute__((swift_name("notifyListeners(queryKeys:)")));
- (void)removeListenerQueryKeys:(ClickstreamKotlinArray<NSString *> *)queryKeys listener:(id<ClickstreamRuntimeQueryListener>)listener __attribute__((swift_name("removeListener(queryKeys:listener:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SettingsClickStreamSettings")))
@interface ClickstreamSettingsClickStreamSettings : ClickstreamBase
- (instancetype)initWithSettings:(id<ClickstreamMultiplatform_settingsSettings>)settings __attribute__((swift_name("init(settings:)"))) __attribute__((objc_designated_initializer));
@property NSString * _Nullable installId __attribute__((swift_name("installId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SettingsEventPropertiesSettings")))
@interface ClickstreamSettingsEventPropertiesSettings : ClickstreamBase
- (instancetype)initWithSettings:(id<ClickstreamMultiplatform_settingsSettings>)settings __attribute__((swift_name("init(settings:)"))) __attribute__((objc_designated_initializer));
@property NSString * _Nullable lastViewId __attribute__((swift_name("lastViewId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformPlatformConnectionType")))
@interface ClickstreamPlatformPlatformConnectionType : ClickstreamKotlinEnum<ClickstreamPlatformPlatformConnectionType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClickstreamPlatformPlatformConnectionType *wifi __attribute__((swift_name("wifi")));
@property (class, readonly) ClickstreamPlatformPlatformConnectionType *cellular __attribute__((swift_name("cellular")));
@property (class, readonly) ClickstreamPlatformPlatformConnectionType *unknown __attribute__((swift_name("unknown")));
+ (ClickstreamKotlinArray<ClickstreamPlatformPlatformConnectionType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClickstreamPlatformPlatformConnectionType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformEventPropertiesDelegate")))
@interface ClickstreamPlatformEventPropertiesDelegate : ClickstreamBase
- (instancetype)initWithDependencies:(id<ClickstreamPlatformPlatformDependencies>)dependencies __attribute__((swift_name("init(dependencies:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamPlatformEventAdditionalProperties *)getIncrementCounter:(BOOL)incrementCounter __attribute__((swift_name("get(incrementCounter:)")));
- (ClickstreamPlatformViewId *)getViewId __attribute__((swift_name("getViewId()")));
- (void)resetCounter __attribute__((swift_name("resetCounter()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol ClickstreamKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<ClickstreamKotlinKClass>)kClass provider:(id<ClickstreamKotlinx_serialization_coreKSerializer> (^)(NSArray<id<ClickstreamKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<ClickstreamKotlinKClass>)kClass serializer:(id<ClickstreamKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<ClickstreamKotlinKClass>)baseClass actualClass:(id<ClickstreamKotlinKClass>)actualClass actualSerializer:(id<ClickstreamKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<ClickstreamKotlinKClass>)baseClass defaultDeserializerProvider:(id<ClickstreamKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<ClickstreamKotlinKClass>)baseClass defaultDeserializerProvider:(id<ClickstreamKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<ClickstreamKotlinKClass>)baseClass defaultSerializerProvider:(id<ClickstreamKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol ClickstreamKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol ClickstreamKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol ClickstreamKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol ClickstreamKotlinKClass <ClickstreamKotlinKDeclarationContainer, ClickstreamKotlinKAnnotatedElement, ClickstreamKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end

__attribute__((swift_name("RuntimeQueryListener")))
@protocol ClickstreamRuntimeQueryListener
@required
- (void)queryResultsChanged __attribute__((swift_name("queryResultsChanged()")));
@end

__attribute__((swift_name("RuntimeTransactionCallbacks")))
@protocol ClickstreamRuntimeTransactionCallbacks
@required
- (void)afterCommitFunction:(void (^)(void))function __attribute__((swift_name("afterCommit(function:)")));
- (void)afterRollbackFunction:(void (^)(void))function __attribute__((swift_name("afterRollback(function:)")));
@end

__attribute__((swift_name("RuntimeTransacterTransaction")))
@interface ClickstreamRuntimeTransacterTransaction : ClickstreamBase <ClickstreamRuntimeTransactionCallbacks>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)afterCommitFunction:(void (^)(void))function __attribute__((swift_name("afterCommit(function:)")));
- (void)afterRollbackFunction:(void (^)(void))function __attribute__((swift_name("afterRollback(function:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (id<ClickstreamRuntimeQueryResult>)endTransactionSuccessful:(BOOL)successful __attribute__((swift_name("endTransaction(successful:)")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) ClickstreamRuntimeTransacterTransaction * _Nullable enclosingTransaction __attribute__((swift_name("enclosingTransaction")));
@end

__attribute__((swift_name("RuntimeQueryResult")))
@protocol ClickstreamRuntimeQueryResult
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)awaitWithCompletionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("await(completionHandler:)")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("RuntimeSqlPreparedStatement")))
@protocol ClickstreamRuntimeSqlPreparedStatement
@required
- (void)bindBooleanIndex:(int32_t)index boolean:(ClickstreamBoolean * _Nullable)boolean __attribute__((swift_name("bindBoolean(index:boolean:)")));
- (void)bindBytesIndex:(int32_t)index bytes:(ClickstreamKotlinByteArray * _Nullable)bytes __attribute__((swift_name("bindBytes(index:bytes:)")));
- (void)bindDoubleIndex:(int32_t)index double:(ClickstreamDouble * _Nullable)double_ __attribute__((swift_name("bindDouble(index:double:)")));
- (void)bindLongIndex:(int32_t)index long:(ClickstreamLong * _Nullable)long_ __attribute__((swift_name("bindLong(index:long:)")));
- (void)bindStringIndex:(int32_t)index string:(NSString * _Nullable)string __attribute__((swift_name("bindString(index:string:)")));
@end

__attribute__((swift_name("RuntimeSqlCursor")))
@protocol ClickstreamRuntimeSqlCursor
@required
- (ClickstreamBoolean * _Nullable)getBooleanIndex:(int32_t)index __attribute__((swift_name("getBoolean(index:)")));
- (ClickstreamKotlinByteArray * _Nullable)getBytesIndex:(int32_t)index __attribute__((swift_name("getBytes(index:)")));
- (ClickstreamDouble * _Nullable)getDoubleIndex:(int32_t)index __attribute__((swift_name("getDouble(index:)")));
- (ClickstreamLong * _Nullable)getLongIndex:(int32_t)index __attribute__((swift_name("getLong(index:)")));
- (NSString * _Nullable)getStringIndex:(int32_t)index __attribute__((swift_name("getString(index:)")));
- (id<ClickstreamRuntimeQueryResult>)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("Multiplatform_settingsSettings")))
@protocol ClickstreamMultiplatform_settingsSettings
@required
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)getBooleanKey:(NSString *)key defaultValue:(BOOL)defaultValue __attribute__((swift_name("getBoolean(key:defaultValue:)")));
- (ClickstreamBoolean * _Nullable)getBooleanOrNullKey:(NSString *)key __attribute__((swift_name("getBooleanOrNull(key:)")));
- (double)getDoubleKey:(NSString *)key defaultValue:(double)defaultValue __attribute__((swift_name("getDouble(key:defaultValue:)")));
- (ClickstreamDouble * _Nullable)getDoubleOrNullKey:(NSString *)key __attribute__((swift_name("getDoubleOrNull(key:)")));
- (float)getFloatKey:(NSString *)key defaultValue:(float)defaultValue __attribute__((swift_name("getFloat(key:defaultValue:)")));
- (ClickstreamFloat * _Nullable)getFloatOrNullKey:(NSString *)key __attribute__((swift_name("getFloatOrNull(key:)")));
- (int32_t)getIntKey:(NSString *)key defaultValue:(int32_t)defaultValue __attribute__((swift_name("getInt(key:defaultValue:)")));
- (ClickstreamInt * _Nullable)getIntOrNullKey:(NSString *)key __attribute__((swift_name("getIntOrNull(key:)")));
- (int64_t)getLongKey:(NSString *)key defaultValue:(int64_t)defaultValue __attribute__((swift_name("getLong(key:defaultValue:)")));
- (ClickstreamLong * _Nullable)getLongOrNullKey:(NSString *)key __attribute__((swift_name("getLongOrNull(key:)")));
- (NSString *)getStringKey:(NSString *)key defaultValue:(NSString *)defaultValue __attribute__((swift_name("getString(key:defaultValue:)")));
- (NSString * _Nullable)getStringOrNullKey:(NSString *)key __attribute__((swift_name("getStringOrNull(key:)")));
- (BOOL)hasKeyKey:(NSString *)key __attribute__((swift_name("hasKey(key:)")));
- (void)putBooleanKey:(NSString *)key value:(BOOL)value __attribute__((swift_name("putBoolean(key:value:)")));
- (void)putDoubleKey:(NSString *)key value:(double)value __attribute__((swift_name("putDouble(key:value:)")));
- (void)putFloatKey:(NSString *)key value:(float)value __attribute__((swift_name("putFloat(key:value:)")));
- (void)putIntKey:(NSString *)key value:(int32_t)value __attribute__((swift_name("putInt(key:value:)")));
- (void)putLongKey:(NSString *)key value:(int64_t)value __attribute__((swift_name("putLong(key:value:)")));
- (void)putStringKey:(NSString *)key value:(NSString *)value __attribute__((swift_name("putString(key:value:)")));
- (void)removeKey:(NSString *)key __attribute__((swift_name("remove(key:)")));
@property (readonly) NSSet<NSString *> *keys __attribute__((swift_name("keys")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformEventAdditionalProperties")))
@interface ClickstreamPlatformEventAdditionalProperties : ClickstreamBase
- (instancetype)initWithTimeZone:(NSString * _Nullable)timeZone timestamp:(NSString * _Nullable)timestamp counter:(int64_t)counter __attribute__((swift_name("init(timeZone:timestamp:counter:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamPlatformEventAdditionalProperties *)doCopyTimeZone:(NSString * _Nullable)timeZone timestamp:(NSString * _Nullable)timestamp counter:(int64_t)counter __attribute__((swift_name("doCopy(timeZone:timestamp:counter:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t counter __attribute__((swift_name("counter")));
@property (readonly) NSString * _Nullable timeZone __attribute__((swift_name("timeZone")));
@property (readonly) NSString * _Nullable timestamp __attribute__((swift_name("timestamp")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformViewId")))
@interface ClickstreamPlatformViewId : ClickstreamBase
- (instancetype)initWithCurrentViewId:(NSString *)currentViewId lastViewId:(NSString * _Nullable)lastViewId __attribute__((swift_name("init(currentViewId:lastViewId:)"))) __attribute__((objc_designated_initializer));
- (ClickstreamPlatformViewId *)doCopyCurrentViewId:(NSString *)currentViewId lastViewId:(NSString * _Nullable)lastViewId __attribute__((swift_name("doCopy(currentViewId:lastViewId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *currentViewId __attribute__((swift_name("currentViewId")));
@property (readonly) NSString * _Nullable lastViewId __attribute__((swift_name("lastViewId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface ClickstreamKotlinByteArray : ClickstreamBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(ClickstreamByte *(^)(ClickstreamInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (ClickstreamKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("KotlinByteIterator")))
@interface ClickstreamKotlinByteIterator : ClickstreamBase <ClickstreamKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (ClickstreamByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
