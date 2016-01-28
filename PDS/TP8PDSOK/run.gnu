set title "Comparaison entre programme avec et sans threads"
set term png
set output "resultat.png"
set logscale x
set dgrid3d 30,30
set pm3d
splot "res.dat" using 1:2:5 with lines
