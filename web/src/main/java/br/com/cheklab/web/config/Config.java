package br.com.cheklab.web.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan("br.com.cheklab.web.*")
@EnableWebMvc
@Import({SecurityConfig.class})
public class Config extends WebMvcConfigurerAdapter {
	
	private static final Map<String, Definition> tiles = new HashMap<String,Definition>();
	private static final Attribute TEMPLATE = new Attribute("/WEB-INF/views/layout/layout.jsp");

	
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitionsFactoryClass(JavaDefinitionsFactory.class);
		tilesConfigurer.setDefinitions(new String[] {});
		addDefinition("home", "Home", "/WEB-INF/views/home.jsp");
		addDefinition("signin", "Sign in", "/WEB-INF/views/signin.jsp");
		addDefinition("signin/facebook", "Sign in", "/WEB-INF/views/signin.jsp");
		return tilesConfigurer;
		
	}
	
	private void addDefinition(String name, String title, String body) {
		Map<String, Attribute> attributes = getDefaultAttributes();
		
		attributes.put("title", new Attribute(title));
		attributes.put("body", new Attribute(body));
		
		tiles.put(name, new Definition(name, TEMPLATE, attributes));
	}
	
	private Map<String, Attribute> getDefaultAttributes() {
		Map<String, Attribute> attributes = new HashMap<String,Attribute>();
		
		attributes.put("header", new Attribute("/WEB-INF/views/layout/header.jsp"));
		attributes.put("menu", new Attribute("/WEB-INF/views/layout/menu.jsp"));
		attributes.put("footer", new Attribute("/WEB-INF/views/layout/footer.jsp"));
		
		return attributes;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/cheklab");
	    driverManagerDataSource.setUsername("admin");
	    driverManagerDataSource.setPassword("123321");
	    return driverManagerDataSource;
	}
	
public static class JavaDefinitionsFactory extends UnresolvingLocaleDefinitionsFactory {
		
		public JavaDefinitionsFactory(){}
		
		 @Override
		public Definition getDefinition(String name, Request tilesContext) {
			return tiles.get(name);
		}
	}
//	
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/view/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
	
	
	
}