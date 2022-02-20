package framework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 调用对象
 * @ClassName Invocation
 * @Author xuwen_chen
 * @Date 2021/1/3 0:37
 * @Version 1.0
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {


    private static final long serialVersionUID = -1L;
    /**
     * 接口.方法名
     */
    private String interfaceName;
    private String methodName;

    /**
     * 参数列表
     */
    private Class<?>[] paramTypes;
    private Object[] params;

}
