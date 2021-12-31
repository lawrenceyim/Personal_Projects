
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Lawrence Yim
 */
public class Main extends Application {
    boolean couponApplied = false;
    
    @Override
    public void start(Stage primaryStage) {
        HBox mainscreen = new HBox();

        // Appliances section
        VBox appliances = new VBox(10);
        appliances.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.15));
        appliances.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black;");
        Text appliancesTitle = new Text("Appliances");
        appliancesTitle.setFont(new Font(20));

        Text refrigerator = new Text("Kolfreeze Refrigerator");
        Text priceRefrigerator = new Text("$1799.00");
        Button purchaseRefrigerator = new Button("Add to cart");

        Text stove = new Text("HotStuff Stove");
        Text priceStove = new Text("$899.00");
        Button purchaseStove = new Button("Add to cart");

        Text freezer = new Text("Deep Dive Freezer");
        Text priceFreezer = new Text("$1100.00");
        Button purchaseFreezer = new Button("Add to cart");

        appliances.getChildren().addAll(appliancesTitle, refrigerator,
                priceRefrigerator, purchaseRefrigerator, stove, priceStove,
                purchaseStove, freezer, priceFreezer, purchaseFreezer);

        // Electronics section
        VBox electronics = new VBox(10);
        electronics.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.15));
        electronics.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black;");

        Text electronicsTitle = new Text("Electronics");
        electronicsTitle.setFont(new Font(20));

        Text tv = new Text("Seeme 80 in TV");
        Text priceTv = new Text("$3000.00");
        Button purchaseTv = new Button("Add to cart");

        Text laptop = new Text("Noi Tall Laptop Computer");
        Text priceLaptop = new Text("$800.00");
        Button purchaseLaptop = new Button("Add to cart");

        Text watch = new Text("Witme Fitness Watch");
        Text priceWatch = new Text("$250.75");
        Button purchaseWatch = new Button("Add to cart");

        electronics.getChildren().addAll(electronicsTitle, tv, priceTv, purchaseTv,
                laptop, priceLaptop, purchaseLaptop, watch, priceWatch, purchaseWatch);

        // Sporting goods section
        VBox sportingGoods = new VBox(10);
        sportingGoods.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.15));
        sportingGoods.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black;");

        Text sportingGoodsTitle = new Text("Sporting Goods");
        sportingGoodsTitle.setFont(new Font(20));

        Text treadmill = new Text("Treadonme Treadmill");
        Text priceTreadmill = new Text("$650.00");
        Button purchaseTreadmill = new Button("Add to cart");

        Text weights = new Text("Gimme A liff Weight Set");
        Text priceWeights = new Text("$1200.00");
        Button purchaseWeights = new Button("Add to cart");

        Text skis = new Text("Cold Shoulder Ski set");
        Text priceSkis = new Text("$485.00");
        Button purchaseSkis = new Button("Add to cart");

        sportingGoods.getChildren().addAll(sportingGoodsTitle, treadmill,
                priceTreadmill, purchaseTreadmill, weights, priceWeights,
                purchaseWeights, skis, priceSkis, purchaseSkis);

        // Cart section
        VBox cart = new VBox(10);
        cart.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.35));

        TableView<Product> tableView = new TableView<>();
        ObservableList<Product> data = FXCollections.observableArrayList();
        tableView.setItems(data);
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.50));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));

        TableColumn priceColumn = new TableColumn("Price");
        priceColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.50));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("Price"));

        tableView.getColumns().addAll(nameColumn, priceColumn);

        Button deleteItem = new Button("Remove from cart");

        cart.getChildren().addAll(tableView, deleteItem);

        // Checkout section
        VBox checkout = new VBox();
        checkout.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.20));

        Text checkoutTitle = new Text("Checkout");
        checkoutTitle.setFont(new Font(20));

        Text coupon = new Text("Coupon code");
        TextField couponcode = new TextField();
        Button applyCoupon = new Button("Apply coupon code");
        Text couponStatus = new Text(); 
        Text amount = new Text("Amount: ");
        Text tax = new Text("Tax: ");
        Text total = new Text("Total: ");

        checkout.getChildren().addAll(checkoutTitle, coupon, couponcode,
                applyCoupon, couponStatus, amount, tax, total);

        // Button event handlers
        purchaseRefrigerator.setOnAction(e -> {
            data.add(new KolfreezeRefrigerator());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseStove.setOnAction(e -> {
            data.add(new HotStuffStove());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseFreezer.setOnAction(e -> {
            data.add(new DeepDiveFreezer());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseTv.setOnAction(e -> {
            data.add(new Seeme80InTV());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseLaptop.setOnAction(e -> {
            data.add(new NoiTallLaptopComputer());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseWatch.setOnAction(e -> {
            data.add(new WitmeFitnessWatch());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseTreadmill.setOnAction(e -> {
            data.add(new TreadonmeTreadmill());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseWeights.setOnAction(e -> {
            data.add(new GimmeALifWeightSet());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        purchaseSkis.setOnAction(e -> {
            data.add(new ColdShoulderSkiSet());
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        deleteItem.setOnAction(e -> {
            Product selectedProduct = tableView.getSelectionModel().getSelectedItem();
            tableView.getItems().remove(selectedProduct);
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);

        });

        applyCoupon.setOnAction(e -> {
            String couponCode = couponcode.getText();
            if (couponCode.equals("ILOVEJAVA")) {
                couponApplied = true;
                couponStatus.setText("Coupon code applied.");
            } else {
                couponApplied = false;
                couponStatus.setText("Invalid coupon code.");
            }
            calculate(tableView, couponApplied, priceColumn, amount, tax, total);
        });

        // Add children to the HBox
        mainscreen.getChildren().addAll(appliances, electronics, sportingGoods,
                cart, checkout);

        Scene scene = new Scene(mainscreen, 1000, 400);
        primaryStage.setTitle("Shopping Catalog");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void calculate(TableView tableView, Boolean couponApplied,
            TableColumn priceColumn, Text amount, Text tax, Text total) {
            double totalAmount = 0;
            for (int i = 0; i < tableView.getItems().size(); i++) {
                totalAmount += (double) priceColumn.getCellData(i);
            }
            if (couponApplied) {
                totalAmount *= .9;
            }
            amount.setText("Amount: $" + String.format("%.2f", totalAmount));
            double taxAmount = totalAmount * .07;
            tax.setText("Tax: $" + String.format("%.2f", taxAmount));
            double totalPlusTax = totalAmount * 1.07;
            total.setText("Total: $" + String.format("%.2f", totalPlusTax));
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
