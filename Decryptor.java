import java.util.Scanner;

/**
 * @author Jason.Tian
 */
public class Decryptor
{

	public static void main(String[] args)
	{
		int line;
		String keyStr, message;

		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter a Key: ");
		keyStr = input.nextLine();
		System.out.println("Enter encrypted message: ");
		message = input.nextLine();
		input.close();

		char key[] = keyStr.toCharArray();
		char wordArray[] = message.toCharArray();

		line = columnLength(message, key.length);
		char column[][] = new char[line][key.length];

		setupColumn(column, wordArray, key);
		displayDecryptedMessage(column, key);
		// displayColumn(column,key); //display the column (for test)

	}

	public static int columnLength(String message, float keyLength)
	{
		int lines;
		lines = (int) Math.ceil(message.length() / keyLength) + 1;
		return lines;
	}

	public static void setupColumn(char column[][], char wordArray[], char key[])
	{
		int numOfSpace, line;
		int wordIndex = 0;

		char n[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		for (int i = 0; i < key.length; i++)
			column[0][i] = key[i]; // set first line of column as key

		numOfSpace = wordArray.length % key.length;
		line = column.length - 1;

		for (int j = numOfSpace; j < key.length; j++)
		{
			if (numOfSpace == 0)
				break;
			else
				column[line][j] = ' '; // set up blank spaces in the last line of column
		}

		for (int i = 0; i < key.length; i++)
		{
			for (int j = 0; j < key.length; j++)
			{
				if (column[0][j] == n[i])
				{
					for (int k = 1; k < column.length; k++)
					{
						if (column[k][j] == ' ')
							break;
						if (wordIndex < wordArray.length)
						{
							column[k][j] = wordArray[wordIndex];
							wordIndex++;
						}
					}
				}
			}
		}

	}

	public static void displayDecryptedMessage(char column[][], char key[])
	{
		System.out.println("The decrypted message is:");
		for (int i = 1; i < column.length; i++)
			for (int j = 0; j < key.length; j++)
				System.out.print(column[i][j]);
		System.out.print("\n");
	}

	public static void displayColumn(char column[][], char key[])
	{
		System.out.print("\n");
		for (int i = 0; i < column.length; i++)
		{
			for (int j = 0; j < key.length; j++)
				System.out.print(column[i][j]);
			System.out.print("\n");
		}
	}

}
