import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
public class Gender {
	private static String genderCheck = "female";
	 public static class Map extends MapReduceBase implements Mapper {
	        private final static IntWritable one = new IntWritable(1);
	        private Text locText = new Text();
	        
	        public void map(LongWritable key, Text value, OutputCollector output, Reporter reporter) throws IOException {
	            String line = value.toString();
	            String location = line.split(",")[14] + "," + line.split(",")[15];
	            long male = 0L;
	            long female = 0L;
	            if (line.split(",")[17].matches("\\d+") && line.split(",")[18].matches("\\d+")) {
	                male = Long.parseLong(line.split(",")[17]);
	                female = Long.parseLong(line.split(",")[18]);
	            }
	            long diff = male - female;
	            locText.set(location);
	            if (Gender.genderCheck.toLowerCase().equals("female") && diff < 0) {
	                output.collect(locText, new LongWritable(diff * -1L));
	            }
	            else if (Gender.genderCheck.toLowerCase().equals("male") && diff > 0) {
	                output.collect(locText, new LongWritable(diff));               
	 
	            }
	        }

			@Override
			public void map(Object arg0, Object arg1, OutputCollector arg2,
					Reporter arg3) throws IOException {
				// TODO Auto-generated method stub
				
			}
	    }
	
	public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Gender.class);
        conf.setJobName("gender");
        conf.setOutputKeyClass(Text.class); 
        conf.setOutputValueClass(LongWritable.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        conf.setMapperClass(Map.class);

        if (args.length != 3) {
            System.out.println("Usage:");
            System.out.println("[male/female] /path/to/2kh/files /path/to/output");
            System.exit(1);
        }

        if (!args[0].equalsIgnoreCase("male") && !args[0].equalsIgnoreCase("female")) {
            System.out.println("first argument must be male or female");
            System.exit(1);
        }         
        Gender.genderCheck = args[0];

        FileInputFormat.setInputPaths(conf, new Path(args[1]));
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        JobClient.runJob(conf);
    }
}
