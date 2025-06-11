package cn.bugstack.infrastructure.dcc;

import cn.bugstack.types.anotation.DCCValue;
import org.springframework.stereotype.Service;

@Service
public class DCCService {

    // 降级开关 0关闭，1开启
    @DCCValue("downGradeSwitch:0")
    private String downGradeSwitch;

    // 切量范围
    @DCCValue("cutRange:100")
    private String cutRange;

    public boolean isDowngradeSwitch() {
        return "1".equals(downGradeSwitch);
    }

    public boolean isCutRange(String userId) {
        int hashCode = Math.abs(userId.hashCode());
        int lastTwoDigits = hashCode % 100;
        if (lastTwoDigits <= Integer.parseInt(cutRange)) {
            return true;
        }
        return false;
    }
}
