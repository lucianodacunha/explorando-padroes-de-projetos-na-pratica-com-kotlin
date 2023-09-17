package io.github.lucianodacunha.patterns.builder

class Product(val name: String, val price: Double, val quantity: Int)

class CustomOrder private constructor(
    val customerName: String,
    val products: List<Product>,
    val total: Double,
    val deliveryAddress: String
) {
    class Builder {
        private var customerName: String = ""
        private var products: MutableList<Product> = mutableListOf()
        private var deliveryAddress: String = ""

        fun setCustomerName(name: String) = apply { customerName = name }
        fun addProduct(product: Product) = apply { products.add(product) }
        fun setDeliveryAddress(address: String) = apply { deliveryAddress = address }

        fun build(): CustomOrder {
            //TODO: Implemente a lógica para calcular o Total do Pedido (a partir dos dados de Produtos).
            //TODO: Instancie corretamente um CustomOrder, consolidando o Builder!
            var totalOrder = 0.0
            for (product in this.products){
                for (i in 1..product.quantity){
                    totalOrder += product.price
                }
            }
            return CustomOrder(customerName, products, totalOrder, deliveryAddress)
        }
    }

    fun printReceipt() {
        println("${this.customerName}")
        this.products.forEachIndexed { index, product ->
            println("${index + 1}. ${product.name} | ${product.price} | ${product.quantity}")
        }
        println("Total: ${this.total}")
        println("End: ${this.deliveryAddress}")
    }
}

fun main() {
    print("Entre com o nome do cliente: ")
    val customerName = readLine() ?: ""

    val orderBuilder = CustomOrder.Builder().setCustomerName(customerName)

    print("Entre com a quantidade de produtos: ")
    val numProducts = readLine()?.toIntOrNull() ?: 0
    for (i in 1..numProducts) {
        print("Entre com o nome do produto: ")
        val productName = readLine() ?: ""
        print("Entre com o preco do produto: ")
        val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
        print("Entre com a qtde. do produto: ")
        val productQuantity = readLine()?.toIntOrNull() ?: 0

        orderBuilder.addProduct(Product(productName, productPrice, productQuantity))
    }

    print("Entre com o endereco do cliente: ")
    val deliveryAddress = readLine() ?: ""

    val customOrder = orderBuilder.setDeliveryAddress(deliveryAddress).build()

    customOrder.printReceipt()

}