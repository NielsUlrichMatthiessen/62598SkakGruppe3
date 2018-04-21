package fen;

import data.Board;
import interfaces.IPiece;
import interfaces.IPiece.Type;
import piece.*;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FEN {


    private static final String FILE_PATH = "FENlog.txt";

    public static Board decode(String FEN) throws InvalidFENStringException
    {
        String[] parts = FEN.split(" ");
        String piecePlacements[] = parts[0].split("/");
        String turn = parts[1];
        String castling = parts[2];
        String enPassant = parts[3];
        String halfmoveClock = parts[4];
        String fillmoveNumber = parts[5];
        Board board = new Board();
        IPiece piece = null;
        String result = "";
        ////////////////////////////////////////////////////////////
        ///////
        /////// Here we determine the piece-placement
        ///////
        ////////////////////////////////////////////////////////////
        for(int y = 7 ; y>=0 ; y-- )
        {
            String row = piecePlacements[y];
            String rowResult = "";
            int x = 0;
            for(int rowStr = 0 ;rowStr <row.length() ; rowStr++)
            {
                char p = row.charAt(rowStr);
                if(p >= '0' && p<= '9')
                {
                    int emptyCells = (int)(p-'0');
                    for(int i = 0 ; i<emptyCells ; i++)
                    {
                        rowResult += " ";
                    }
                    x += emptyCells;
                }
                else
                {
                    rowResult += p;

                    Point point = new Point(x,y);
                    switch(p)
                    {
                        case 'p':
                            piece = new Pawn(IPiece.Color.BLACK , point);
                            break;
                        case 'P':
                            piece = new Pawn(IPiece.Color.WHITE , point);
                            break;
                        case 'n':
                            piece = new Knight(IPiece.Color.BLACK , point);
                            break;
                        case 'N':
                            piece = new Knight(IPiece.Color.WHITE , point);
                            break;
                        case 'b':
                            piece = new Bishop(IPiece.Color.BLACK , point);
                            break;
                        case 'B':
                            piece = new Bishop(IPiece.Color.WHITE , point);
                            break;
                        case 'r':
                            piece = new Rook(IPiece.Color.BLACK , point);
                            break;
                        case 'R':
                            piece = new Rook(IPiece.Color.WHITE , point);
                            break;
                        case 'q':
                            piece = new Queen(IPiece.Color.BLACK , point);
                            break;
                        case 'Q':
                            piece = new Queen(IPiece.Color.WHITE , point);
                            break;
                        case 'k':
                            piece = new King(IPiece.Color.BLACK , point);
                            break;
                        case 'K':
                            piece = new King(IPiece.Color.WHITE , point);
                            break;
                    }
                    board.setPiece(point , piece);
                    x++;

                }

            }
            if(rowResult.length() != 8)
                throw new InvalidFENStringException("Invalid piece placement:\""+row+"\"\nfen.FEN STRING:\""+FEN+"\"");
            result+=rowResult+"\n";
        }
        ////////////////////////////////////////////////////////////
        ///////
        /////// Here we determine whose turn it is
        ///////
        ////////////////////////////////////////////////////////////
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

        ////////////////////////////////////////////////////////////
        ///////
        /////// here we determine castling
        ///////
        ////////////////////////////////////////////////////////////
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

        ////////////////////////////////////////////////////////////
        ///////
        ///////  Here we determine en passant squares
        ///////
        ////////////////////////////////////////////////////////////
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

        ////////////////////////////////////////////////////////////
        ///////
        ///////  So far we haven't implemented the timers
        ///////
        ////////////////////////////////////////////////////////////
        System.out.println(result);
        return board;
    }

    public static String encode(Board board)
    {
        String finalResult = "";
        String[] boardString = new String[8];
        String playerturn = "";
        String castling = "";
        String enPassant = "";
        String halfmoveclock = "0";
        String fullmovenumber  = "";
        for(int y = 7 ; y>=0 ; y--)
        {
            String row = "";
            int emptyFields = 0;
            for(int x = 0 ; x<8 ; x++)
            {
                IPiece piece = board.getPiece(new Point(x,y));
                if(piece == null)
                {
                    emptyFields++;
                    if(x == 7)
                    {
                        row += emptyFields;
                    }
                }
                else
                {
                    if(emptyFields != 0)
                    {
                        row += emptyFields;
                        emptyFields = 0;
                    }
                    String pieceStr = "";
                    switch (piece.getType())
                    {
                        case Pawn:
                            pieceStr = "p";
                            break;
                        case Rook:
                            pieceStr = "r";
                            break;
                        case Knight:
                            pieceStr = "n";
                            break;
                        case Bishop:
                            pieceStr = "b";
                            break;
                        case Queen:
                            pieceStr = "q";
                            break;
                        case King:
                            pieceStr = "k";
                            break;
                    }
                    if(piece.getColor() == IPiece.Color.WHITE)
                    {
                        pieceStr = pieceStr.toUpperCase();
                    }
                    row += pieceStr;
                }
            }
            row += y == 0 ? "": "/";
        }



        System.out.println(finalResult);
        return finalResult;
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
