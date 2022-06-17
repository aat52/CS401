// CS 401 Fall 2019 Lab 12 Main Program
// Your job is to complete this program so that it runs correctly.
// The Movie class and MovieDB class are idential to those from Lab7. 
// The only difference is that now the main program has a graphical
// interface, and it is written in a more object oriented way (ex: the
// movies variable is now an instance variable rather than a method
// variable).  I have written the interface, but have only implemented
// part of the ControlListener class (which is the ActionListener for
// the buttons), so that it currently responds to only the findMovie 
// button. You must complete the ControlListener implementation
// so that the other 3 buttons work correctly.

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab12 {
	private MovieDB movies; // MovieDB variable to store movies
	private JFrame theWindow; // Window
	private JPanel controlPanel, infoPanel; // Panels for the
	// control buttons and the information
	private JButton listMovies, addMovie, findMovie, quit;
	// JButtons for various actions
	private JTextArea info; // See Mousey.java for example
	private JScrollPane scroller; // with these classes
	private ActionListener theListener;

	public Lab12() throws IOException {
		movies = new MovieDB(10); // Still making DB only size 10
		loadData(); // Load movies from file

		// Create and initialize the graphical components for the
		// program. Note carefully how everything is set up. Some of
		// these components may not be familiar to you. However, the
		// important part of this is the buttons and how you will respond
		// to the button clicks.
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 2));

		listMovies = new JButton("List Movies");
		addMovie = new JButton("Add Movie");
		findMovie = new JButton("Find Movie");
		quit = new JButton("Quit");

		// Add ControlListener to all 4 buttons
		theListener = new ControlListener();
		listMovies.addActionListener(theListener);
		addMovie.addActionListener(theListener);
		findMovie.addActionListener(theListener);
		quit.addActionListener(theListener);

		controlPanel.add(listMovies);
		controlPanel.add(addMovie);
		controlPanel.add(findMovie);
		controlPanel.add(quit);

		// Similar to handout Mousey.java, we are putting a JTextArea
		// and a JScrollPane into this JPanel.
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		info = new JTextArea(); // see JTextArea rows and columns
		info.setColumns(40);
		info.setRows(20);
		scroller = new JScrollPane(info);
		infoPanel.add(scroller);

		theWindow = new JFrame("Lab 12");
		// Don't quit the program when "X" is clicked -- user
		// must use the Quit button
		theWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		theWindow.add(controlPanel, BorderLayout.NORTH);
		theWindow.add(infoPanel, BorderLayout.SOUTH);
		// pack() to size JFrame as needed
		theWindow.pack();
		theWindow.setVisible(true);
	}

	private class ControlListener implements ActionListener {
		// This method should respond to all four of the buttons in the program.
		// However, as written here only one button is actually handled. You
		// must add the code to handle the other three buttons. You can get a lot
		// of help from the code below. Also see various course handouts and notes.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == findMovie) {
				String t = JOptionPane.showInputDialog(theWindow, "Movie name? "); // Get movie name from user
				Movie mov = movies.findMovie(t); // search DB for it
				info.setText(""); // empty out the JTextArea

				if (mov != null) { // add found movie to it
					String outdata = mov.toString();
					info.append(outdata);
					theWindow.pack();
				} else { // indicate that movie was not found
					info.append("Sorry, but " + t + " was not found");
					theWindow.pack();
				}
			}

			// The List Movies button.
			// This button should call the toString() method of the MoviesDB object (movies)
			// and append the result to the JTextArea.
			// This option must update the JTextArea in a nice way, so that only the data
			// that is needed is shown, and
			// so that the JFrame is sized just enough to hold the data in the JTextArea
			// (hint: pack()).
			if (e.getSource() == listMovies) {
				info.append(movies.toString());
				theWindow.pack();
			}

			// The Add Movie button.
			// This button should prompt the user (via JOptionPane.showInputDialog() boxes)
			// for all of the components of the new movie,
			// then create the Movie object and add it to the MovieDB (movies) variable.
			// Finally, the new movie should be printed to the JTextArea to show the user
			// that it has been added.
			// This option must update the JTextArea in a nice way, so that only the data
			// that is needed is shown, and
			// so that the JFrame is sized just enough to hold the data in the JTextArea
			// (hint: pack()).
			if (e.getSource() == addMovie) {
				// Get inputs from user
				// Simpler dialog with less options provided
				String title = JOptionPane.showInputDialog("Title?");
				String director = JOptionPane.showInputDialog("Director?");
				String studio = JOptionPane.showInputDialog("Studio?");
				double gross = Double.parseDouble(JOptionPane.showInputDialog("Gross?"));

				// Create a new movie object based on user inputs
				Movie newMovie = new Movie(title, director, studio, gross);
				movies.addMovie(newMovie);

				// Ouput the new movie to JTextArea
				info.setText(""); // empty out the JTextArea
				info.append(newMovie.toString());
				theWindow.pack();
			}

			// The Quit program button.
			// The user should be asked to confirm the quit using a
			// JOptionPane.showConfirmDialog() box.
			// If the confirmation is given, the MovieDB should be saved back to the file
			// and the program will be terminated.
			// To terminate a Java graphical application, you can issue the statement
			// System.exit(0).
			if (e.getSource() == quit) {
				if (JOptionPane.showConfirmDialog(null, "Click Yes to Save Movie Data and Quit, No to Cancel.",
						"Confirm Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					saveData();
					System.exit(0);
				}
			}
		}
	}

	// The first 6 lines are setting some standard fonts for the GUI
	// The last line is creating a Lab12 object, which does everything else.
	public static void main(String[] args) throws IOException {
		UIManager.put("Button.font", new Font("TimesRoman", Font.BOLD, 35));
		UIManager.put("TextField.font", new Font("TimesRoman", Font.BOLD, 35));
		UIManager.put("Label.font", new Font("TimesRoman", Font.BOLD, 35));
		UIManager.put("OptionPane.messageFont", new Font("TimesRoman", Font.BOLD, 35));
		UIManager.put("OptionPane.buttonFont", new Font("TimesRoman", Font.BOLD, 25));
		UIManager.put("TextArea.font", new Font("TimesRoman", Font.BOLD, 20));

		new Lab12();
	}

	// Instance method to read in data from file into MovieDB
	private void loadData() throws IOException {
		// Note the syntax below for creating a Scanner to a file
		Scanner S = new Scanner(new FileInputStream("movieFile.txt"));
		int sz = Integer.parseInt(S.nextLine());

		for (int i = 0; i < sz; i++) {
			String t = S.nextLine();
			String d = S.nextLine();
			String st = S.nextLine();
			double g = Double.parseDouble(S.nextLine());

			Movie temp = new Movie(t, d, st, g);
			movies.addMovie(temp);
		}
	}

	// Instance method to save data back to the file. I have used an
	// exception handler here just to avoid a compilation error. We will
	// discuss exception handling later.
	private void saveData() {
		try {
			PrintWriter P = new PrintWriter("movieFile.txt");
			// Note that we are printing the entire DB to the file with
			// one statement. This is because the toStringFile() method
			// of the MovieDB class calls the toStringFile() method of
			// each Movie within the DB.
			P.print(movies.toStringFile());
			P.close();
		} catch (IOException e) {
		}
	}
}
