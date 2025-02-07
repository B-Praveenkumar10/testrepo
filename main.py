import qrcode

def generate_qr(data, filename="qrcode.png", size=10):
    """
    Generates a QR code for the given data and saves it as an image.
    
    Parameters:
        data (str): The data to encode in the QR code.
        filename (str): The name of the output image file.
        size (int): The size of the QR code (default is 10).
    """
    qr = qrcode.QRCode(
        version=1,  # Controls the size of the QR code (1 is smallest)
        error_correction=qrcode.constants.ERROR_CORRECT_L,
        box_size=size,
        border=4,
    )
    
    qr.add_data(data)
    qr.make(fit=True)

    img = qr.make_image(fill="black", back_color="white")
    img.save(filename)
    print(f"QR Code saved as {filename}")

if __name__ == "__main__":
    print("QR Code Generator")
    text = input("Enter the text or URL to generate QR code: ")
    file_name = input("Enter filename (default: qrcode.png): ") or "qrcode.png"
    size = input("Enter box size (default: 10): ")

    try:
        size = int(size) if size else 10
        generate_qr(text, file_name, size)
    except ValueError:
        print("Invalid size! Using default size 10.")

    print("QR code generated successfully!")
