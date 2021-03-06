
package sample;

import javax.servlet.ServletContext;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author Ankush.Verman
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {

	public Initializer() {
		super(Config.class);
	}

	@Override
	protected void afterSessionRepositoryFilter(ServletContext servletContext) {
		appendFilters(servletContext, new UserAccountsFilter());
	}
}
