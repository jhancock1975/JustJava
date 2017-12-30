package com.example.adroid.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private static int PRICE = 5;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = createOrderSummary(calculatePrice());
        displayMessage(priceMessage);
    }

    /**
     * create string containing the order summary
     *
     * @param price - the price of the order
     * @return - string containing the order summary
     */
    private String createOrderSummary(int price) {
        return "Name: John Hancock\nQuantity: " + qty + "\nTotal: $" + price + "\nThank you!";
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        qty++;
        display(qty);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (qty > 0) {
            qty--;
        }
        display(qty);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice() {
        return qty * PRICE;
    }
    
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}