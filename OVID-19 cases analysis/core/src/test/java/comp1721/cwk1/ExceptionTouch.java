package comp1721.cwk1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author zlysimida
 * @date 2021/3/28 - 11:49
 */
public class ExceptionTouch {
    @Test
    /**
     * 测试触发ExceptionTouchtest类
     */
    public void ExceptionTouchtest(){
        Class cr = null;
        try {
            cr = Class.forName("comp1721.cwk1.CaseRecord");
            Field staffCases = cr.getDeclaredField("staffCases");
            staffCases.setAccessible(true);
            staffCases.set(cr,-1);
            Field studentCases = cr.getDeclaredField("studentCases");
            studentCases.setAccessible(true);
            studentCases.set(cr,-1);
            Field otherCases = cr.getDeclaredField("otherCases");
            otherCases.setAccessible(true);
            otherCases.set(cr,-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
