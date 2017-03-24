package com.example.user.justtry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity =0;
    boolean javaChip = false;
    boolean whippedCream = false;
    String customerName = "";
    String total = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
        quantity = quantity -1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText customerEV = (EditText)findViewById(R.id.customer_name);
        customerName = customerEV.getText().toString();

        String summaryText = "";
        summaryText = "Name: " + customerName;
        if(whippedCream || javaChip){
            summaryText += "\nToppings:";
            if(javaChip)
                summaryText += "\n\t\t- Java Chips";
            if(whippedCream)
                summaryText += "\n\t\t- Whipped Cream";
        }
        summaryText += "\nQuantity: " + quantity;
        displayPrice(quantity);
        summaryText += "\nTotal: " + total;
        summaryText += "\nThank you!";
        displaySummary(summaryText);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        total = NumberFormat.getCurrencyInstance().format(number*5);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displaySummary(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.summary_text);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.topping_java_chip:
                if(checked)
                    javaChip = true;
                else
                    javaChip = false;
                break;
            case R.id.topping_whipped_cream:
                if(checked)
                    whippedCream = true;
                else
                    whippedCream = false;
                break;
        }
    }
}