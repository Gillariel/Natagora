<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Comment Entity
 *
 * @property int $ID
 * @property string $Message
 * @property \Cake\I18n\FrozenTime $Date
 * @property int $Likes
 * @property int $Dislikes
 * @property int $Reported
 * @property int $Forum_ID
 */
class Comment extends Entity
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
        'Message' => true,
        'Date' => true,
        'Likes' => true,
        'Dislikes' => true,
        'Reported' => true,
        'Forum_ID' => true
    ];
}
