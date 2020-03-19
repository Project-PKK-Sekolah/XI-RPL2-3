-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Mar 2020 pada 02.57
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sma`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_assets`
--

CREATE TABLE `t_assets` (
  `id_assets` int(255) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jmlh_barang` varchar(255) NOT NULL,
  `lokasi_barang` varchar(10) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_data_diri`
--

CREATE TABLE `t_data_diri` (
  `id_data` int(255) NOT NULL,
  `username` varchar(100) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_login`
--

CREATE TABLE `t_login` (
  `username` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_transaksi`
--

CREATE TABLE `t_transaksi` (
  `id_assets` int(255) NOT NULL,
  `id_data` int(255) NOT NULL,
  `username` varchar(100) NOT NULL,
  `jmlh_pinjam` varchar(10) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `t_assets`
--
ALTER TABLE `t_assets`
  ADD PRIMARY KEY (`id_assets`);

--
-- Indeks untuk tabel `t_data_diri`
--
ALTER TABLE `t_data_diri`
  ADD PRIMARY KEY (`id_data`),
  ADD KEY `username` (`username`);

--
-- Indeks untuk tabel `t_login`
--
ALTER TABLE `t_login`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `t_transaksi`
--
ALTER TABLE `t_transaksi`
  ADD KEY `id_assets` (`id_assets`),
  ADD KEY `username` (`username`),
  ADD KEY `id_data` (`id_data`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `t_assets`
--
ALTER TABLE `t_assets`
  MODIFY `id_assets` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `t_data_diri`
--
ALTER TABLE `t_data_diri`
  MODIFY `id_data` int(255) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `t_data_diri`
--
ALTER TABLE `t_data_diri`
  ADD CONSTRAINT `t_data_diri_ibfk_1` FOREIGN KEY (`username`) REFERENCES `t_login` (`username`);

--
-- Ketidakleluasaan untuk tabel `t_transaksi`
--
ALTER TABLE `t_transaksi`
  ADD CONSTRAINT `t_transaksi_ibfk_1` FOREIGN KEY (`id_assets`) REFERENCES `t_assets` (`id_assets`),
  ADD CONSTRAINT `t_transaksi_ibfk_2` FOREIGN KEY (`id_data`) REFERENCES `t_data_diri` (`id_data`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
