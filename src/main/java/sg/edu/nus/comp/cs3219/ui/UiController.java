package sg.edu.nus.comp.cs3219.ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.swing.JTextArea;

import sg.edu.nus.comp.cs3219.control.MasterControl;

public class UiController {
	public interface KwicUi {
		/**
		 * Get the input String lists
		 */
		List<String> getInput();

		/**
		 * Get the input strings as an String array
		 */
		String[] getInputArray();

		/**
		 * Get the output text area in the UI
		 */
		JTextArea getOutputTextArea();

		/**
		 * Get the "words to ignore" set
		 */
		Set<String> getIgnoredWords();

		/**
		 * Get the "required words" set
		 */
		Set<String> getRequiredWords();

		/**
		 * Set the generated KWIC results in the UI
		 */
		void setResutls(List<String> results);

		/**
		 * Set the UI Controller
		 */
		void setController(UiController controller);
	}

	final private KwicUi view;

	private MasterControl controller;

	public UiController(KwicUi view) {
		this.view = view;
		controller = new MasterControl();
	}

	public void generateResult() {
		// Get entered ignored words from GUI
		Set<String> ignoredWordsSet = view.getIgnoredWords();
		// Get entered required words from GUI
		Set<String> requiredWordsSet = view.getRequiredWords();
		// Run the application
		List<String> result = controller.run(view.getInput(), ignoredWordsSet);
		// Display result
		view.setResutls(result);
	}

	public void exportResultToFile(String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("./output.txt"));
			view.getOutputTextArea().write(writer);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}
}
