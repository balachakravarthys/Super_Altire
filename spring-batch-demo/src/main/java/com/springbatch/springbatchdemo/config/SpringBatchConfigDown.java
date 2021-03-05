package com.springbatch.springbatchdemo.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.springbatchdemo.batch.DBReader;
import com.springbatch.springbatchdemo.model.User;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfigDown {
	
	@Bean(value="JobDBtoCSV")
    public Job jobWriter(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<User> itemRead,
                   ItemWriter<User> itemWrite
    ) {

        Step step = stepBuilderFactory.get("ETL-file-down")
                .<User, User>chunk(100)
                .reader(itemRead)
                .writer(itemWrite)
                .build();
       
        
       
        

        return jobBuilderFactory.get("ETL-down")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }
	
	@Bean(value="itemRead")
	public ItemReader<User> itemRead() {

		return new DBReader();
	}


	
	  @Bean(value="itemWrite")
	  public FlatFileItemWriter<User> itemWrite() 
	  { 
		  FlatFileItemWriter<User> flatItemWriter = new FlatFileItemWriter<User>();
	  flatItemWriter.setResource(new FileSystemResource("uploads/user_Down.csv"));
	  DelimitedLineAggregator<User> delimitedLineAggregator = new
	  DelimitedLineAggregator<User>();
	  delimitedLineAggregator.setDelimiter(",");
	  BeanWrapperFieldExtractor<User> fieldExtractor = new BeanWrapperFieldExtractor<User>(); fieldExtractor.setNames(new
	  String[]{"id","dept", "name", "salary"});
	  delimitedLineAggregator.setFieldExtractor(fieldExtractor);
	  
	  flatItemWriter.setLineAggregator(delimitedLineAggregator); return
	  flatItemWriter;
	  }
	 
	 
	
	 
	
}
