package com.example.adroid.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private static final int PRICE = 5;
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
        // Get checked/not checked state of whipped cream checkbox
        boolean addWhippedCream = ((CheckBox) findViewById(R.id.whipped_checkbox)).isChecked();
        Log.d(this.getClass().getSimpleName(), "addWhippedCream = " + addWhippedCream);


        // Get checked/not checked state of chocolate checkbox
        boolean addChocolate= ((CheckBox) findViewById(R.id.chocolate_checkbox)).isChecked();
        Log.d(this.getClass().getSimpleName(), "addChocolate = " + addChocolate);

        String userName = ((EditText) findViewById(R.id.user_name)).getText().toString();
        Log.d(this.getClass().getSimpleName(), "user_name =" + userName);


        String priceMessage = createOrderSummary(calculatePrice(), addWhippedCream, addChocolate,
                userName);

        displayMessage(priceMessage);
    }

    /**
     * create string containing the order summary
     *
     * @param price - the price of the order
     * @param addWhippedCream - we will use to display true or false after the add whipped cream
     *                        question in the order summary
     * @param addChocolate - we will use to display true or false after the add chocolate
     *                        question in the order summary
     * @param userName - name the user entered at the top of the order form
     * @return - string containing the order summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream,
                                      boolean addChocolate, String userName) {

        return "Name: " + userName
                + "\nAdd whipped cream? " + addWhippedCream
                + "\nAdd chocolate? " + addChocolate
                + "\nQuantity: " + qty
                + "\nTotal: $" + price
                + "\nThank you!";
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