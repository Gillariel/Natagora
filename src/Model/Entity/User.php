<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * User Entity
 *
 * @property int $ID
 * @property string $Pseudo
 * @property string $Name
 * @property string $Forname
 * @property string $Mail
 * @property string $Password
 * @property \Cake\I18n\FrozenTime $Join_Date
 * @property string $Picture
 * @property int $Role_ID
 */
class User extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * Note that when '*' is set to true, this allows all unspecified fields to
     * be mass assigned. For security purposes, it is advised to set '*' to false
     * (or remove it), and explicitly make individual fields accessible as needed.
     *
     * @var array
     */
    protected $_accessible = [
        'Pseudo' => true,
        'Name' => true,
        'Forname' => true,
        'Mail' => true,
        'Password' => true,
        'Join_Date' => true,
        'Picture' => true,
        'Role_ID' => true
    ];
}
