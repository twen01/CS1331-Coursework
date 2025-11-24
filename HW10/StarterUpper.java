import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Collaboration Statement:
 * I worked on the homework assignment alone, using only course materials.
 *
 * <p>
 * StarterUpper is a JavaFX application that allows users to collect and rank
 * startup ideas.
 *
 * @author Thomas Williams
 * @version 1.0
 */
public class StarterUpper extends Application {
    private List<StartUpIdea> ideas;
    private ObservableList<String> observableIdeas;
    private TextField problemField;
    private TextField customerField;
    private TextField needField;
    private TextField peopleField;
    private TextField marketField;
    private TextField competitorField;
    private ListView<String> ideasListView;

    private VBox controlsBox;
    private TextField eProblemField;
    private TextField eCustomerField;
    private TextField eNeedField;
    private TextField ePeopleField;
    private TextField eMarketField;
    private TextField eCompetitorField;
    private Button doneButton;
    private Button cancelButton;
    private int selectedIndex = -1;

    private Button removeButton;

    /**
     * Starts the JavaFX application and displays the form.
     *
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) {
        ideas = new ArrayList<>();
        observableIdeas = FXCollections.observableArrayList();

        VBox root = new VBox();

        Label initials = new Label("TW");
        initials.setStyle("-fx-text-fill: green;");
        root.getChildren().add(initials);
        root.getChildren().add(new Button("903988702"));

        try {
            Image buzz = new Image(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:"
                            + "ANd9GcTjweAdPjEN9QvSKkLu2Jh78q_QACFK3J1miw&s",
                    true);
            ImageView imageView = new ImageView(buzz);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            root.getChildren().add(imageView);
        } catch (Exception e) {
            System.out.println(
                    "Failed to load https://encrypted-tbn0.gstatic.com/images?"
                            + "q=tbn:ANd9GcTjweAdPjEN9QvSKkLu2Jh78q_QACFK3J1miw&s");
        }

        Label problemLabel = new Label("What is the problem?");
        problemField = new TextField();
        root.getChildren().addAll(problemLabel, problemField);

        Label customerLabel = new Label("Who is the target customer?");
        customerField = new TextField();
        root.getChildren().addAll(customerLabel, customerField);

        Label needLabel = new Label("How badly does the customer NEED this problem fixed (1-10)?");
        needField = new TextField();
        root.getChildren().addAll(needLabel, needField);

        Label peopleLabel = new Label("How many people do you know who might experience this problem?");
        peopleField = new TextField();
        root.getChildren().addAll(peopleLabel, peopleField);

        Label marketLabel = new Label("How big is the target market?");
        marketField = new TextField();
        root.getChildren().addAll(marketLabel, marketField);

        Label competitorLabel = new Label("Who are the competitors/existing solutions?");
        competitorField = new TextField();
        root.getChildren().addAll(competitorLabel, competitorField);

        Button addButton = new Button("Add Idea");
        addButton.setOnAction(e -> handleAddIdea());

        Button sortButton = new Button("Sort Ideas");
        sortButton.setOnAction(e -> handleSortIdeas());

        Button resetForm = new Button("Reset Form");
        resetForm.setOnAction(e -> handleResetForm());

        Button saveIdeas = new Button("Save Ideas");
        saveIdeas.setOnAction(e -> handleSaveIdeas());

        root.getChildren().addAll(addButton, sortButton, resetForm, saveIdeas);

        Label ideasLabel = new Label("Ideas List:");
        ideasListView = new ListView<>(observableIdeas);
        ideasListView.setPrefHeight(80);
        ideasListView.setOnMouseClicked(e -> handleSelectIdea());
        root.getChildren().addAll(ideasLabel, ideasListView);

        controlsBox = createEditControls();
        root.getChildren().add(controlsBox);

        Scene scene = new Scene(root, 500, 810);

        stage.setTitle("Problem Ideation Form");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates edit controls section.
     *
     * @return A VBox
     */
    private VBox createEditControls() {
        VBox eBox = new VBox();

        Label eTitle = new Label("Edit Selected Idea");
        eBox.getChildren().add(eTitle);

        Label eProblemLabel = new Label("Problem:");
        eProblemField = new TextField();
        eProblemField.setDisable(true);
        eBox.getChildren().addAll(eProblemLabel, eProblemField);

        Label eCustomerLabel = new Label("Target Customer:");
        eCustomerField = new TextField();
        eCustomerField.setDisable(true);
        eBox.getChildren().addAll(eCustomerLabel, eCustomerField);

        Label eNeedLabel = new Label("Need (1-10):");
        eNeedField = new TextField();
        eNeedField.setDisable(true);
        eBox.getChildren().addAll(eNeedLabel, eNeedField);

        Label ePeopleLabel = new Label("People Count:");
        ePeopleField = new TextField();
        ePeopleField.setDisable(true);
        eBox.getChildren().addAll(ePeopleLabel, ePeopleField);

        Label eMarketLabel = new Label("Market Size (1-10):");
        eMarketField = new TextField();
        eMarketField.setDisable(true);
        eBox.getChildren().addAll(eMarketLabel, eMarketField);

        Label eCompetitorLabel = new Label("Competitors:");
        eCompetitorField = new TextField();
        eCompetitorField.setDisable(true);
        eBox.getChildren().addAll(eCompetitorLabel, eCompetitorField);

        doneButton = new Button("Done Editing");
        doneButton.setOnAction(e -> handleEditDone());
        doneButton.setDisable(true);

        cancelButton = new Button("Cancel Edit");
        cancelButton.setOnAction(e -> handleEditCancel());
        cancelButton.setDisable(true);

        removeButton = new Button("Remove Idea");
        removeButton.setOnAction(e -> handleRemoveIdea());
        removeButton.setDisable(true);

        eBox.getChildren().addAll(doneButton, cancelButton, removeButton);

        return eBox;

    }

    /**
     * Handles selecting an idea.
     */
    private void handleSelectIdea() {
        int index = ideasListView.getSelectionModel().getSelectedIndex();
        if (index >= 0 && index < ideas.size()) {
            selectedIndex = index;
            StartUpIdea idea = ideas.get(index);

            eProblemField.setText(idea.getProblem());
            eCustomerField.setText(idea.getTargetCustomer());
            eNeedField.setText(String.valueOf(idea.getCustomerNeed()));
            ePeopleField.setText(String.valueOf(idea.getKnownPeopleWithProblem()));
            eMarketField.setText(String.valueOf(idea.getTargetMarketSize()));
            eCompetitorField.setText(idea.getCompetitors());

            eProblemField.setDisable(false);
            eCustomerField.setDisable(false);
            eNeedField.setDisable(false);
            ePeopleField.setDisable(false);
            eMarketField.setDisable(false);
            eCompetitorField.setDisable(false);
            doneButton.setDisable(false);
            cancelButton.setDisable(false);
            removeButton.setDisable(false);
        }
    }

    /**
     * Handles removing the currently selected idea.
     */
    private void handleRemoveIdea() {
        if (selectedIndex < 0 || selectedIndex >= ideas.size()) {
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Removal");
        confirmAlert.setHeaderText("Are you sure you want to remove this idea?");
        confirmAlert.setContentText(eProblemField.getText());

        Optional<ButtonType> result = confirmAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            ideas.remove(selectedIndex);
            observableIdeas.remove(selectedIndex);
            showAlert("Success", "Idea removed successfully");
            handleEditCancel();
        }
    }

    /**
     * Handles completing the edit of a selected idea.
     */
    private void handleEditDone() {
        if (selectedIndex < 0 || selectedIndex >= ideas.size()) {
            return;
        }

        if (eProblemField.getText().isEmpty() || eCustomerField.getText().isEmpty()
                || eNeedField.getText().isEmpty() || ePeopleField.getText().isEmpty()
                || eMarketField.getText().isEmpty() || eCompetitorField.getText().isEmpty()) {
            showAlert("Invalid Input", "Please ensure all fields are filled with valid values");
            return;
        }

        try {
            int need = Integer.parseInt(eNeedField.getText());
            int people = Integer.parseInt(ePeopleField.getText());
            int market = Integer.parseInt(eMarketField.getText());

            if (need < 1 || need > 10 || people < 0 || market < 1 || market > 10) {
                showAlert("Invalid Input", "Please ensure all fields are filled with valid values");
                return;
            }

            // Update the idea
            StartUpIdea idea = ideas.get(selectedIndex);
            idea.setProblem(eProblemField.getText());
            idea.setTargetCustomer(eCustomerField.getText());
            idea.setCustomerNeed(need);
            idea.setKnownPeopleWithProblem(people);
            idea.setTargetMarketSize(market);
            idea.setCompetitors(eCompetitorField.getText());

            // Update the observable list
            observableIdeas.set(selectedIndex, eProblemField.getText());

            showAlert("Success", "Idea updated successfully");
            handleEditCancel();

        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please ensure all integer fields contain valid integers");
        }
    }

    /**
     * Handles cancelling the edit mode.
     */
    private void handleEditCancel() {
        selectedIndex = -1;
        eProblemField.clear();
        eCustomerField.clear();
        eNeedField.clear();
        ePeopleField.clear();
        eMarketField.clear();
        eCompetitorField.clear();

        eProblemField.setDisable(true);
        eCustomerField.setDisable(true);
        eNeedField.setDisable(true);
        ePeopleField.setDisable(true);
        eMarketField.setDisable(true);
        eCompetitorField.setDisable(true);
        doneButton.setDisable(true);
        cancelButton.setDisable(true);
        removeButton.setDisable(true);

        ideasListView.getSelectionModel().clearSelection();
    }

    /**
     * Validates all input fields to ensure they meet requirements.
     *
     * @return true if all inputs are valid, false otherwise
     */
    private boolean validateInputs() {
        if (problemField.getText().isEmpty() || customerField.getText().isEmpty()
                || needField.getText().isEmpty() || peopleField.getText().isEmpty()
                || marketField.getText().isEmpty() || competitorField.getText().isEmpty()) {
            return false;
        }

        try {
            int need = Integer.parseInt(needField.getText());
            int people = Integer.parseInt(peopleField.getText());
            int market = Integer.parseInt(marketField.getText());

            if (need < 1 || need > 10 || people < 0 || market < 1 || market > 10) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Clears all text fields in the form.
     */
    private void clearFields() {
        problemField.clear();
        customerField.clear();
        needField.clear();
        peopleField.clear();
        marketField.clear();
        competitorField.clear();
    }

    /**
     * Shows an alert dialog to the user.
     *
     * @param title   the title of the alert
     * @param message the message to display in the alert
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles adding a new startup idea to the list.
     */
    private void handleAddIdea() {
        if (!validateInputs()) {
            showAlert("Invalid Input", "Please ensure all fields are filled with valid values");
            return;
        }
        try {
            String problem = problemField.getText();
            String customer = customerField.getText();
            int need = Integer.parseInt(needField.getText());
            int people = Integer.parseInt(peopleField.getText());
            int market = Integer.parseInt(marketField.getText());
            String competitors = competitorField.getText();

            StartUpIdea idea = new StartUpIdea(problem, customer, need, people, market, competitors);
            ideas.add(idea);
            observableIdeas.add(problem);
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please ensure all integer fields contain valid integers");
        }
    }

    /**
     * Sorts the ideas list based on their potential value.
     */
    private void handleSortIdeas() {
        Collections.sort(ideas);
    }

    /**
     * Handles resetting the form after user confirmation.
     */
    private void handleResetForm() {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Reset");
        confirmAlert.setHeaderText("Are you sure you want to reset?");

        Optional<ButtonType> result = confirmAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            ideas.clear();
            observableIdeas.clear();
            clearFields();
            handleEditCancel();

            File file = new File("ideas.txt");
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * Handles saving all ideas to a file.
     */
    private void handleSaveIdeas() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    File file = new File("ideas.txt");
                    boolean isSaved = FileUtil.saveIdeasToFile(ideas, file);

                    if (isSaved) {
                        showAlert("Success", "Ideas saved to ideas.txt");
                    } else {
                        showAlert("Error", "Failed to save ideas to file");
                    }
                } catch (Exception e) {
                    showAlert("Error", e.getMessage());
                }
            }
        };
        runnable.run();
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
