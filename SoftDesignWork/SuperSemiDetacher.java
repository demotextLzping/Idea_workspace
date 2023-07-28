/**
 * @author: LZPing
 * @date: 2023-04-22 17:20
 * @Description
 */

public class SuperSemiDetacher implements SemiDetacher {
    private String name;

    public SuperSemiDetacher(String cName) {
        name = cName;
    }

    public String getSemiDetacherInfo() {
        return "superSemiDetacher.htm1";
    }

    public String getSemiDetacherFeatures() {
        return "Super SemiDetacher ";
    }
}

