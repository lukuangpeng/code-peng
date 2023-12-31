package cloud.ffeng.user.domain.platform.repository;

import cloud.ffeng.user.domain.platform.aggregate.PlatformAuthFlow;

/**
 * @author cat-feng
 */
public interface PlatformAuthRepository {

    /**
     * 获取平台授权ID
     *
     * @param platformAuthFlowId 平台授权ID
     * @return 授权流水信息
     */
    PlatformAuthFlow get(String platformAuthFlowId);


    /**
     * 保存授权流水信息
     *
     * @param platformAuthFlow 授权流水信息
     * @return 授权流水信息
     */
    PlatformAuthFlow save(PlatformAuthFlow platformAuthFlow);
}
