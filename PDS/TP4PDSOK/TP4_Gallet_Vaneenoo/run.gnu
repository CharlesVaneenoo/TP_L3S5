set title "Temps d'execution en fonction de la taille du buffer"
set term png
set output "mcat.png"
set logscale x
set xlabel "Taille du buffer"
set logscale y
set ylabel "Temps en secondes"
set style data linespoints
plot "mcat-tm.dat" using 1:2 title "real",  "mcat-tm.dat" using 1:3 title "user", "mcat-tm.dat" using 1:4 title "sys"
