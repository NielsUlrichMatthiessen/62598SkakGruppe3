package fen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FEN {


    private static final String FILE_PATH = "FENlog.txt";

    public static void decode(String FEN) throws InvalidFENStringException
    {
        String[] parts = FEN.split(" ");
        String piecePlacements[] = parts[0].split("/");
        String turn = parts[1];
        String castling = parts[2];
        String enPassant = parts[3];
        String halfmoveClock = parts[4];
        String fillmoveNumber = parts[5];
        String result = "";
        for(int y = 0 ; y<8 ; y++ )
        {
            String row = piecePlacements[y];
            String rowResult = "";
            for(int x = 0 ;x <row.length() ; x++)
            {
                char p = row.charAt(x);
                if(p >= '0' && p<= '9')
                {
                    int emptyCells = (int)(p-'0');
                    for(int i = 0 ; i<emptyCells ; i++)
                    {
                        rowResult += " ";
                    }
                }
                else
                {
                    rowResult += p;
                }

            }
            if(rowResult.length() != 8)
                throw new InvalidFENStringException("Invalid piece placement:\""+row+"\"\nfen.FEN STRING:\""+FEN+"\"");
            result+=rowResult+"\n";
        }
        switch(turn)
        {

            case "w":
                result += "White player's turn\n";
                break;
            case "b":
                result += "Black player's turn\n";
                break;
            default:
                throw new InvalidFENStringException("Invalid active player character:\""+turn+"\"\nfen.FEN STRING:\""+FEN+"\"");
        }

        if(castling.equals("-"))
            result += "neither side can castle\n";
        else
        {
            for(char c : castling.toCharArray())
            {
                switch(c)
                {
                    case 'K':
                        result += "White can castle kingside\n";
                        break;
                    case 'Q':
                        result += "White can castle queenside\n";
                        break;
                    case 'k':
                        result += "Black can castle kingside\n";
                        break;
                    case 'q':
                        result += "Black can castle queenside\n";
                        break;
                    default:
                        throw new InvalidFENStringException("Invalid castling character:\""+castling+"\"\nfen.FEN STRING:\""+FEN+"\"");
                }
            }
        }

        if(enPassant.equals("-"))
        {
            result += "None en passant squares\n";
        }
        else
        {
            if(enPassant.length() != 2 || (enPassant.charAt(0) < 'a' || enPassant.charAt(0) > 'h') || (enPassant.charAt(1) < '0' || enPassant.charAt(1) > '8'))
                throw new InvalidFENStringException("Invalid en passant characters:\""+enPassant+"\"\nfen.FEN STRING:\""+FEN+"\"");
            else
            {
                int column = (int)(enPassant.charAt(0)-'a');
                int row = (int)(enPassant.charAt(1)-'0');
                result += "En passant square(Column,Row) :(" + column+","+row+") or "+enPassant;
            }

        }
        System.out.println(result);

    }

    public static String encode()
    {
        return "";
    }

    public static void saveToFile(String FEN)
    {

        try{
            FEN += "\n";
            Files.write(Paths.get(FILE_PATH), FEN.getBytes(), StandardOpenOption.APPEND);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[])
    {
        String fen = "rnbqkbnr/pp2pppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2";
        try {
            decode(fen);
            saveToFile(fen);
        } catch (InvalidFENStringException e) {
            e.printStackTrace();
        }


    }
}
