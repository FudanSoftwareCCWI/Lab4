package wm.view.test;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * 
 * @author Sidney Fan
 * 
 */
public class MouseListenerMatcher extends BaseMatcher<MouseListener> {

	protected MouseListener mouseListener;

	@Override
	public boolean matches(Object item) {
		mouseListener = (MouseListener) item;
		return true;
	}

	@Override
	public void describeTo(Description arg0) {
	}

	public void mouseClicked(Component source) {
		mouseListener.mouseClicked(new MouseEvent(source,
				MouseEvent.MOUSE_CLICKED, 0, MouseEvent.BUTTON1_DOWN_MASK , 1, 1, 1,
				false));
	}
}
