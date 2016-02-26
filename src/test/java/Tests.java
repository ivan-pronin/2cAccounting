import org.junit.Test;

/**
 * Created by Администратор on 26.02.2016.
 */

/*
Currently cannot run this class due to

Class not found: "Tests"Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8

Process finished with exit code 1
Empty test suite.
 */
public class Tests {

    public Tests()
    {

    }

    @Test
    public void test1()
    {
        org.junit.Assert.assertTrue(true);
        System.out.println(Tax.NDS.name());
        System.out.println(Tax.TAX_NAME.toString());
    }

    @Test
    public void test2()
    {
        org.junit.Assert.assertTrue(false);
    }


    private enum Tax{
        NDS, TAX_NAME;
    }
}
