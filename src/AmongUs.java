public class AmongUs {
	Stack<String> stack = new Stack<String>();
	public void analyzeCommand(String command) {
		if (command.contains("/")) {
			String[] encryption = command.split("/");
			switch (encryption[0]) {
			case "i":
				this.insert(encryption[1], Integer.parseInt(encryption[2]));
				break;
			case "d":
				this.delete(Integer.parseInt(encryption[1]), Integer.parseInt(encryption[2]));
				break;
			case "a":
				this.append(encryption[1]);
				break;

			default:
				return;
			}
		} else {
			if (command.length() == 1) {
				if (command.charAt(0) == 'p')
					System.out.println(stack.peek());
				else if (command.charAt(0) == 'u')
					this.undo();
				else if (command.charAt(0) == 'c') {
					stack.clear();
					System.out.println();
				}
					
			} else {
				stack.push(command);
			}
		}
	}

	public void insert(String symbols, int position) {
		String current = stack.peek();
		String output = current.substring(0, position) + symbols + current.substring(position);
		stack.push(output);
	}

	public void delete(int start, int end) {
		String current = stack.peek();
		if (current.length() > start) {
			String output = current.substring(0, start) + current.substring(end);
			stack.push(output);
		}

	}

	public void append(String letters) {
		String current = stack.peek();
		String output = current + "" + letters;
		stack.push(output);
	}

	public void undo() {
		if (stack.size() != 1) {
			stack.pop();
		}
	}
}
