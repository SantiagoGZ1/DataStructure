import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stack = new Stack<>();
		if (!tags.isEmpty()) {
			//Etiquetas cerradas en orden incorrecto

			int counter = tags.size();
			for (int i = 0; i < counter; i++) {
				if (tags.element().isSelfClosing()) {
					tags.poll();
				} else if (tags.element().isOpenTag()) {
					stack.push(tags.element());
					tags.poll();
					if (tags.isEmpty()) {
						return stack;
					}
					} else if (stack.isEmpty() && !tags.isEmpty()) {
						return null;
					 }else if (tags.element().matches(stack.peek())) {
						stack.pop();
						tags.poll();
					} else {
						return stack;
					}
				}
			}
		return stack;
		}
	}
