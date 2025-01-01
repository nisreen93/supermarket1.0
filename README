Supermarket Application

*Introduction*
A Spring Boot-based command-line application that simulates a supermarket shopping cart system. The application supports interactive and file-based modes to manage inventory, add items to a cart, apply offers, calculate bills, and perform checkout.

------------------------------------------------------------------------------------

*Features*
Load inventory from a CSV file.
Interactive mode for adding items, applying offers, and generating bills.
File-based mode for processing commands from a file.
Supports two types of offers:
buy_2_get_1_free: Every third item is free.
buy_1_get_half_off: Every second item is charged at half price.
Handles inventory availability and updates stock levels accordingly.

------------------------------------------------------------------------------------

*Getting Started*
Prerequisites
Java 8
Maven 3.9+
A terminal or command prompt

------------------------------------------------------------------------------------

*Project Structure*
src/main/java: Contains application source code.
src/main/resources: Placeholder for additional resources if required.
inventory.csv: Inventory file containing product details (place at the same level as pom.xml).
commands.txt: Command file containing predefined commands for file mode.

------------------------------------------------------------------------------------

*Setup*
*Clone the repository:

/bash
git clone https://github.com/nisreen93/supermarket1.0.git
cd <file location>
Build the project:

/bash
mvn clean package

*Prepare input files:
Create an inventory.csv file for inventory details.
Optionally, create a commands.txt file for file-based execution.

*Example inventory.csv:
csv
soap,10.00,100
bread,2.50,10
milk,5.00,50
eggs,0.50,200
toothpaste,20.00,30

*Example commands.txt:
plaintext
add soap 5
add bread 2
bill
offer buy_2_get_1_free soap
bill
checkout

------------------------------------------------------------------------------------

*Usage*
*Run the Application

-Interactive Mode:
/bash
java -jar target/SuperMarket-1.0.jar inventory.csv
Example session:

plaintext
> add soap 5
Added 5 soap(s) to the cart.
> bill
subtotal: 50.00, discount: 0.00, total: 50.00
> checkout
Checkout complete.

-File-Based Mode:
/bash
java -jar target/SuperMarket-1.0.jar inventory.csv commands.txt
Example output:
plaintext
Added 5 soap(s) to the cart.
Added 2 bread(s) to the cart.
subtotal: 65.00, discount: 0.00, total: 65.00
Checkout complete.

------------------------------------------------------------------------------------

*Technologies Used*
Java 8: Programming language
Spring Boot: Framework for application structure
Maven: Build tool

------------------------------------------------------------------------------------

*Code Workflow*
*Loading Inventory
The application reads the inventory.csv file and populates the inventory map with product details.
*Command Processing
Interactive commands (add, bill, checkout, etc.) are processed from the console.
In file mode, commands from commands.txt are executed in sequence.
*Offers
Offers are applied dynamically to products in the cart.
The most recent offer on a product overrides previous ones.

------------------------------------------------------------------------------------

*Contact*
For any questions, please feel free to contact me!
