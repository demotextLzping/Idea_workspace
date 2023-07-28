public class MediumSemiDetacher implements SemiDetacher
{
    private String name;
    public MediumSemiDetacher(String cName)
    {
        name = cName;
    }
    public String getSemiDetacherInfo(){
        return "MediumSemiDetacher.html";
    }
    public String getSemiDetacherFeatures()
    {
        return "Medium SemiDetacher ";
    }
}

