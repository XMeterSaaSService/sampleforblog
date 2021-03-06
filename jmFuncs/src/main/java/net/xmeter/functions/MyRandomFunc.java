package net.xmeter.functions;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

public class MyRandomFunc extends AbstractFunction{
	//自定义function的描述
    private static final List<String> desc = new LinkedList<String>();
    static {
        desc.add("Get a random result string.");
    }
    //function名称
    private static final String KEY = "__MyRandomFunc";

    private SecureRandom random = new SecureRandom();
    private static char[] seeds = "abcdefghijklmnopqrstuvwxmy0123456789".toCharArray();
    
    public List<String> getArgumentDesc() {
        return desc; 
    }

	@Override
	public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < 1024; i++) {
			res.append(seeds[random.nextInt(seeds.length - 1)]);
		}
		return res.toString();
	}

	@Override
	public String getReferenceKey() {
		return KEY;
	}

	@Override
	public void setParameters(Collection<CompoundVariable> arg0) throws InvalidVariableException {
		
	}
    
}
