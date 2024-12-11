package cn.iocoder.yudao.framework.encrypt.core.enums;

/**
 * 接口加密支持的算法类型
 */
public enum AlgorithmType {
    RSA("RSA"),
    AES("AES");
    private final String value;

    AlgorithmType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
