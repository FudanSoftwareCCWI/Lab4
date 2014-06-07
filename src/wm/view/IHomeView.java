package wm.view;

/**
 * Interface IHomeView represents a home view and is managed by a home view
 * controller. It is the beginning view of the application.
 * 
 * @author Sidney Fan
 * 
 */
public interface IHomeView {
	
	/**
	 * <b>refreshHome</b>
	 * <pre><code>public void <b>refreshHome</b>()</code></pre>
	 * <blockquote>
	 * <p>RefreshHome to repaint the select panel. This must be invoke after any view swiched to home view.</p>
	 * </blockquote>
	 */
	public void refreshHome();
}
