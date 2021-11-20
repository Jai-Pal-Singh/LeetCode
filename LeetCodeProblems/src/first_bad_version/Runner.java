package first_bad_version;

import java.util.logging.*;

public class Runner {
    private static final Logger logger = Logger.getLogger(Runner.class.getName());
    public static void main(String[] args) {
        VersionControl vc = new VersionControl(new boolean[]{false, false, false, false, false, false, false, true, true, true});
        Solution sol = new Solution(vc);
        logger.log(Level.INFO,"Output : {0}" , sol.firstBadVersion(10));
    }
}
