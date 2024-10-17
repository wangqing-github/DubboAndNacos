package elasticjob;

import beans.UserInfo;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;

import java.util.ArrayList;
import java.util.List;

public class FlowJob implements DataflowJob<UserInfo> {
    @Override
    public List<UserInfo> fetchData(ShardingContext shardingContext) {
        List<UserInfo> foos = new ArrayList<>();
        double random = Math.random();
        System.out.println("fetchData------ " + random);
        if (random > 0.5){
            UserInfo foo = new UserInfo();
            foo.setUserName("小道仙");
            foos.add(foo);
        }
        return foos;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<UserInfo> list) {

    }
}
